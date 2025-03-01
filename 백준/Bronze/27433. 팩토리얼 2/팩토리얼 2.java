import java.util.*;
import java.io.*;

public class Main {
	static List<int[]>[] G;
	static int[] edge;
	static boolean[] visited;
	static List<Integer> MST;
	static long totalWeight = 0;
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> edge[o1] - edge[o2]);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int V = Integer.parseInt(st.nextToken());
//		int E = Integer.parseInt(st.nextToken());
//
//		edge = new int[E];
//		G = new List[V + 1];
//		visited = new boolean[V + 1];
//		for (int i = 1; i <= V; i++)
//			G[i] = new ArrayList<>();
//
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine());
//			int v1 = Integer.parseInt(st.nextToken());
//			int v2 = Integer.parseInt(st.nextToken());
//			int w = Integer.parseInt(st.nextToken());
//
//			G[v1].add(new int[] { v2, i });
//			G[v2].add(new int[] { v1, i });
//			edge[i] = w;
//		}
//
//		// find MST
//		prim(1);
//
//		System.out.println(totalWeight);

		int N = Integer.parseInt(br.readLine());
		long rst = 1;
		for (int i = 2; i <= N; i++) {
			rst *= i;
		}
		
		System.out.println(rst);
	}

	public static void prim(int v) {
		visited[v] = true;

		// MST 트리의 모든 간선 추가
		for (int[] node : G[v])
			pq.add(node[1]);

		boolean stop = false;
		while (!pq.isEmpty() && !stop) {
			int e = pq.poll();

			for (int[] node : G[v]) {
				if (node[1] == e && !visited[node[0]]) {
					totalWeight += edge[e];
					prim(node[0]);
					stop = true;
					break;
				}
			}
		}

	}
}