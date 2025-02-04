import java.util.*;
import java.io.*;

public class Main {
	static long C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] sk = new int[2][N];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sk[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][N + 2];
			for (int i = 2; i < N + 2; i++) {
				for (int j = 0; j < 2; j++) {
					int dp1, dp2, dp3;
					if (j == 0) {
						dp1 = dp[j + 1][i - 1];
						dp2 = dp[j + 1][i - 2];
						dp3 = dp[j][i - 2];
					} else {
						dp1 = dp[j - 1][i - 1];
						dp2 = dp[j - 1][i - 2];
						dp3 = dp[j][i - 2];
					}

					dp[j][i] = Math.max(dp1, Math.max(dp2, dp3)) + sk[j][i - 2];
				}
			}

			sb.append(Math.max(dp[0][N + 1], dp[1][N + 1])).append("\n");
		}

		System.out.println(sb);
	}

}
