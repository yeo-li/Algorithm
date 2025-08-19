import java.util.*;
import java.io.*;

public class Main {
	static int[] nums;
	static int[][] dp;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		nums = new int[N + 1];
		dp = new int[2][N + 1];
		cnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());

			if (i == 1) {
				dp[0][i] = nums[i];
				dp[1][i] = nums[0];
				cnt[i] = 1;
				continue;
			} else if (i == 2) {
				dp[0][i] = dp[0][1] + nums[i];
				dp[1][i] = nums[i];
				cnt[i] = 2;
				continue;
			}

			if (cnt[i - 1] == 2) {
				dp[0][i] = dp[1][i - 1] + nums[i];
				cnt[i] = 2;
			} else {
				dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]) + nums[i];
				cnt[i] = 2;
			}

			dp[1][i] = Math.max(dp[1][i - 2], dp[0][i - 2]) + nums[i];
		}

		System.out.println(Math.max(dp[1][N], dp[0][N]));
	}

}