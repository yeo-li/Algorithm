import java.util.*;
import java.io.*;

public class Main {

	static boolean[] lights;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		lights = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			lights[i] = st.nextToken().equals("1");
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			boolean isMale = Integer.parseInt(st.nextToken()) == 1;
			int num = Integer.parseInt(st.nextToken());

			if (isMale)
				updateMan(num);
			else
				updateWoman(num);
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(lights[i] ? "1" : "0");
			if (i != N)
				System.out.print(" ");
			if (i % 20 == 0 && i != N)
				System.out.println();
		}
	}

	public static void updateMan(int num) {
		for (int i = num; i <= N; i += num)
			lights[i] = !lights[i];
	}

	public static void updateWoman(int num) {
		int r = num + 1;
		int l = num - 1;

		lights[num] = !lights[num];

		while (1 <= l && r <= N && lights[r] == lights[l]) {
			lights[r] = !lights[r];
			lights[l] = !lights[l];
			r++;
			l--;
		}
	}

}
