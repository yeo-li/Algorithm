import java.util.*;
import java.io.*;

public class Main {
	static Map<Integer, List<Integer>> G = new HashMap<>();
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			G.put(i, new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			G.get(v1).add(v2);
			G.get(v2).add(v1);
		}

		System.out.println(dfs(A, B));

	}

	public static int dfs(int A, int B) {
		boolean[] visited = new boolean[N + 1];
		Deque<int[]> dq = new ArrayDeque<>();

		for (int v : G.get(A)) {
			if (v == B)
				return 1;
			dq.offer(new int[] { v, 1 });
			visited[v] = true;
		}

		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			for (int v : G.get(now[0])) {
				if (!visited[v]) {
					if (v == B)
						return now[1] + 1;
					dq.offer(new int[] { v, now[1] + 1 });
					visited[v] = true;
				}
			}
		}

		return -1;
	}

}
