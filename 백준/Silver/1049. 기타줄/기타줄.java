import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int p = Integer.MAX_VALUE;
		int s = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			p = Math.min(p, Integer.parseInt(st.nextToken()));
			s = Math.min(s, Integer.parseInt(st.nextToken()));

		}
		
		int packagePrice = (N < 6) ? p : Math.min((N / 6 + 1) * p, N / 6 * p + N % 6 * s);
		int singlePrice = N * s;

		System.out.println(Math.min(packagePrice, singlePrice));
	}

}