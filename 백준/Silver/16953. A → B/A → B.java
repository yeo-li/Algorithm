import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int cnt = 1;
		while (start < end) {
			if (end % 2 == 0)
				end /= 2;
			else if (end % 10 == 1) {
				end /= 10;
			} else
				break;
			cnt++;
		}
		
		if(start == end) System.out.println(cnt);
		else System.out.println(-1);
	}

}
