import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] Tree;
	static boolean[] visited;
	static int rst;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		Tree = new List[N + 1];

		for (int i = 0; i <= N; i++)
			Tree[i] = new ArrayList<>();

		// connect node
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			Tree[U].add(V);
			Tree[V].add(U);
		}

		// Query
		StringBuilder sb = new StringBuilder();
		dp = new int[N + 1];
		for (int i = 0; i < Q; i++) {
			int U = Integer.parseInt(br.readLine());
			rst = dp[U];
			if (rst == 0) {
				visited = new boolean[N + 1];
				postorder(R, U);
			}
			sb.append(rst).append("\n");
		}

		System.out.println(sb);
	}

	public static int postorder(int root, int U) {
		if (visited[root])
			return 0;
		visited[root] = true;

		int totalCnt = 0;
		for (int vertex : Tree[root]) {
			totalCnt += postorder(vertex, U);
		}

		dp[root] = totalCnt + 1;

		if (root == U) {
			rst = totalCnt + 1;
		}

		return totalCnt + 1;

	}

}