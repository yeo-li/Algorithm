import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] changedPw = br.readLine().toCharArray();
		long k = Long.parseLong(br.readLine()) - 1L;

		char[] pw = new char[changedPw.length];
		List<int[]> list = new ArrayList<>();
		for (int i = changedPw.length - 1; i >= 0; i--) {

			if (changedPw[i] == '1' || changedPw[i] == '6') {
				list.add(new int[] { i, 0 });
				pw[i] = '1';
				continue;
			}

			if (changedPw[i] == '2' || changedPw[i] == '7') {
				list.add(new int[] { i, 1 });
				pw[i] = '2';
				continue;
			}

			pw[i] = changedPw[i];
		}

		if (k > 1L<<list.size()) {
			System.out.println(-1);
			return;
		}

		int idx = 0;
		while (k != 0) {
			int mod = (int)(k%2);
			int index = list.get(idx)[0];
			if (mod == 1) {
				if (list.get(idx)[1] == 0) {
					pw[index] = '6';
				} else {
					pw[index] = '7';
				}
			}
			k /= 2;
			idx++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : pw) {
			sb.append(c);
		}
		
		System.out.println(sb);

	}

}
