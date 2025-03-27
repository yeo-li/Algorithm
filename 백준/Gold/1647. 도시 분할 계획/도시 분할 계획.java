import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static List<int[]>[] G;
	static int[] E;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		G = new List[N + 1];
		E = new int[M];
		for (int i = 1; i <= N; i++)
			G[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			G[A].add(new int[] { B, W });
			G[B].add(new int[] { A, W });
			E[i] = W;
		}

		System.out.println(prim());

	}

	public static int prim() {
		boolean[] visited = new boolean[N + 1];
		int total = 0;
		int max = Integer.MIN_VALUE;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		pq.offer(new int[] { 0, 1 });

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (visited[now[1]])
				continue;
			visited[now[1]] = true;

			max = Math.max(max, now[0]);
			total += now[0];

			for (int[] v : G[now[1]]) {
				if (!visited[v[0]])
					pq.offer(new int[] { v[1], v[0] });
			}
		}

		return total - max;
	}

}