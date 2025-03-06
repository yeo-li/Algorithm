import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		dp[1] = 1;

		System.out.println(fb(N));
	}

	public static int fb(int N) {
		if(N == 0) return 0;
		
		if (dp[N] != 0)
			return dp[N];

		dp[N - 1] = fb(N - 1);
		dp[N - 2] = fb(N - 2);
		return dp[N - 1] + dp[N - 2];
	}
}