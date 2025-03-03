import java.util.*;
import java.io.*;

public class Main {
	static List<int[]>[] G;
	static int[][] EDGE;
	static boolean[] visited;
	static long totalWeight = 0;
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> EDGE[o1][2] - EDGE[o2][2]);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		G = new List[V + 1];
		EDGE = new int[E][3];
		visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++)
			G[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			// i는 간선 번호
			G[v1].add(new int[] { v2, i });
			G[v2].add(new int[] { v1, i });
			EDGE[i] = new int[] { v1, v2, w };
		}

		// find MST
		visited[1] = true;

		// MST 트리의 모든 간선 추가
		for (int[] node : G[1]) {
			if (!visited[node[0]])
				pq.add(node[1]);
		}

		while (!pq.isEmpty()) {
			int e = pq.poll();

			if (visited[EDGE[e][0]] && visited[EDGE[e][1]])
				continue;

			totalWeight += EDGE[e][2];
			int node = !visited[EDGE[e][0]] ? EDGE[e][0] : EDGE[e][1];
			visited[node] = true;
			for (int[] vertex : G[node]) {
				if (!visited[vertex[0]])
					pq.add(vertex[1]);
			}
		}

		System.out.println(totalWeight);

	}

}