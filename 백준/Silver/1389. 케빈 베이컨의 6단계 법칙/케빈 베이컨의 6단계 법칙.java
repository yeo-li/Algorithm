import java.util.*;
import java.io.*;

public class Main {
	static Map<Integer, List<Integer>> G;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		G = new HashMap<>();
		for (int i = 1; i <= N; i++)
			G.put(i, new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			G.get(A).add(B);
			G.get(B).add(A);
		}

		int min = Integer.MAX_VALUE;
		int user = 0;
		for (int i = 1; i <= N; i++) {
			int rst = bfs(i);
			if (min > rst) {
				min = rst;
				user = i;
			}
		}

		System.out.println(user);
	}

	public static int bfs(int V) {
		int[] dist = new int[N + 1];
		for (int i = 1; i <= N; i++)
			dist[i] = Integer.MAX_VALUE;

		Deque<int[]> dq = new ArrayDeque<>();

		dist[V] = 0;
		dq.offer(new int[] { V, 0 });

		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			for (int v : G.get(now[0])) {
				if (dist[v] > now[1] + 1) {
					dist[v] = now[1] + 1;
					dq.offer(new int[] { v, now[1] + 1 });
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += dist[i];
		}

		return sum;
	}

}
