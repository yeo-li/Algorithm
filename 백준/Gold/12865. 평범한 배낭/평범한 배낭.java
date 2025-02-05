import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] w = new int[N];
		int[] v = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				dp[i][j] = dp[i - 1][j];
				if (w[i - 1] <= j)
					dp[i][j] = Math.max(dp[i][j], v[i - 1] + dp[i - 1][j - w[i - 1]]);
			}
		}

		System.out.println(dp[N][K]);
	}

}
