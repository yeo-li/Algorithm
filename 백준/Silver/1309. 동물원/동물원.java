import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][3];
		Arrays.fill(dp[1], 1);

		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
			dp[i][1] = dp[i - 1][2] + dp[i - 1][0];
			dp[i][2] = dp[i - 1][1] + dp[i - 1][0];
			dp[i][0] %= 9901;
			dp[i][1] %= 9901;
			dp[i][2] %= 9901;
		}

		int rst = 0;

		for (int i = 0; i < 3; i++)
			rst += dp[N][i];

		System.out.println(rst % 9901);
	}

}