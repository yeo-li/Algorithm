import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static long D;
	static int[][] rule;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 상자
		K = Integer.parseInt(st.nextToken()); // 규칙
		D = Long.parseLong(st.nextToken()); // 도톨이 수
		rule = new int[K][3];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			rule[i] = new int[] { A, B, C };
		}

		int lo = 0;
		int hi = N + 1;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (check(mid)) {
				hi = mid;
			} else {
				lo = mid;
			}
		}

		System.out.println(hi);
	}

	public static boolean check(int mid) {
		long cnt = 0;
		for (int i = 0; i < K; i++) {
			int end = Math.min(rule[i][1], mid);
			if (rule[i][0] > end)
				continue;
			cnt += (end - rule[i][0]) / rule[i][2] + 1;

			if (cnt >= D)
				return true;
		}
		return false;
	}
}
