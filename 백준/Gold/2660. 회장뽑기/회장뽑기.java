import java.util.*;
import java.io.*;

public class Main {
	static Map<Integer, List<Integer>> G = new HashMap<>();
	static int[] scr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++)
			G.put(i, new ArrayList<>());

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (A == -1 && B == -1)
				break;
			G.get(A).add(B);
			G.get(B).add(A);
		}

		// 점수를 매긴다
		scr = new int[N + 1];
		List<int[]> ans = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				scr[j] = Integer.MAX_VALUE;
			}
			ans.add(new int[] { i, bfs(i) });
		}

		// 최소 점수를 찾는다.
		ans.sort((o1, o2) -> {
			return o1[1] - o2[1];
		});

		// 대충 출력
		StringBuilder sb = new StringBuilder();
		sb.append(ans.get(0)[1]).append(" ");

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (ans.get(0)[1] == ans.get(i)[1])
				cnt++;
		}
		sb.append(cnt).append("\n");

		for (int i = 0; i < cnt; i++) {
			sb.append(ans.get(i)[0]).append(" ");
		}

		System.out.print(sb.toString());

	}

	public static int bfs(int n) {

		Deque<int[]> dq = new ArrayDeque<>();

		scr[n] = 0;
		for (int v : G.get(n)) {
			scr[v] = 1;
			dq.offer(new int[] { v, 1 });
		}

		while (!dq.isEmpty()) {
			int[] v = dq.poll();

			for (int node : G.get(v[0])) {
				if (scr[node] > v[1] + 1) {
					scr[node] = v[1] + 1;
					dq.offer(new int[] { node, v[1] + 1 });
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, scr[i]);
		}

		return max;
	}

}
