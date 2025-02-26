import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp, matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		matrix = new int[N][2];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solve(0, N - 1));

	}

	public static int solve(int start, int end) {
		// dfs 로 풀면 될 것 같은 사실 탑다운이 dfs 일지도~?
		if (start == end)
			return 0;
		if (dp[start][end] != Integer.MAX_VALUE)
			return dp[start][end];

		for (int i = start; i < end; i++) {
			int value = solve(start, i) + solve(i + 1, end) + calculate(start, i, end);
			dp[start][end] = Math.min(dp[start][end], value);
		}

		return dp[start][end];
	}

	public static int calculate(int A, int B, int C) {
		return matrix[A][0] * matrix[B][1] * matrix[C][1];
	}
}