import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;
	static int HP = 100;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] W = new int[N + 1];
		int[] V = new int[N + 1];
		dp = new int[N + 1][HP + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			W[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			V[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= HP; j++) {
				dp[i][j] = dp[i - 1][j];
				if (W[i] < j)
					dp[i][j] = Math.max(dp[i - 1][j], V[i] + dp[i - 1][j - W[i]]);
			}
		}

		System.out.println(dp[N][HP]);
	}

}