import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] dp = new int[D + 1];
		for (int i = 1; i <= D; i++)
			dp[i] = i;

		List<int[]> roads = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			roads.add(new int[] { start, end, dist });
		}

		for (int end = 1; end <= D; end++) {
			for (int start = 0; start <= end; start++) {
				dp[end] = Math.min(dp[end], dp[start] + end - start);
				for (int i = 0; i < N; i++) {
					if (roads.get(i)[1] == end) {
						dp[end] = Math.min(dp[end], dp[roads.get(i)[0]] + roads.get(i)[2]);
					}
				}

			}

		}

		System.out.println(dp[D]);
	}

}
