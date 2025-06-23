import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		dp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		dp[0] = 0;
		for (int i = 1; i < N + 1; i++)
			dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(dp[end] - dp[start - 1]).append("\n");
		}

		System.out.println(sb);
	}

}