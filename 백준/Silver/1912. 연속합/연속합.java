import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N + 1];
		int[] dp = new int[N + 1];
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if (i == 1)
				dp[i] = nums[i];
			else
				dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			if (max < dp[i])
				max = dp[i];
		}

		System.out.println(max);

	}

}
