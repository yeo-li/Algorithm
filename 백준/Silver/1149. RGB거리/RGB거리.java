import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][3];
		int[][] house = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
				int a = 0, b = 0;
				if (j == 0) {
					a = 1;
					b = 2;
				} else if (j == 1) {
					a = 0;
					b = 2;
				} else {
					a = 0;
					b = 1;
				}

				dp[i][j] = house[i][j] + Math.min(dp[i - 1][a], dp[i - 1][b]);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (min > dp[N][i])
				min = dp[N][i];
		}
		
		System.out.println(min);

	}
}
