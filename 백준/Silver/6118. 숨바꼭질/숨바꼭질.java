import java.util.*;
import java.io.*;

public class Main {
	static Map<Integer, List<Integer>> G = new HashMap<>();
	static int N, M;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		distance = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			G.put(i, new ArrayList<>());
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			G.get(A).add(B);
			G.get(B).add(A);
		}

		bfs();

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++)
			max = Math.max(max, distance[i]);

		int cnt = 0, first = 0;
		for (int i = 1; i <= N; i++) {
			if (max == distance[i]) {
				if (first == 0)
					first = i;
				cnt++;
			}
		}

		System.out.println(first + " " + max + " " + cnt);
	}

	public static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();

		distance[1] = 0;
		dq.offer(new int[] { 1, 0 });

		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			for (int v : G.get(now[0])) {
				if (distance[v] > now[1] + 1) {
					distance[v] = now[1] + 1;
					dq.offer(new int[] { v, now[1] + 1 });
				}
			}
		}
	}

}
