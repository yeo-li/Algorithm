import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int M, N, K;
	static List<Integer> cnts = new ArrayList<>();
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[M][N];

		for (int p = 0; p < K; p++) {
			st = new StringTokenizer(br.readLine());
			int[] start = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			int[] end = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			for (int i = start[0]; i < end[0]; i++) {
				for (int j = start[1]; j < end[1]; j++) {
					board[j][i]++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append(bfs()).append("\n");
		Collections.sort(cnts);
		for (int cnt : cnts) {
			sb.append(cnt).append(" ");
		}

		System.out.println(sb);

	}

	public static int bfs() {
		boolean[][] visited = new boolean[M][N];

		Deque<int[]> dq = new ArrayDeque<>();
		int cnt = 0;
		int rst = 0;
		for (int p = 0; p < N * M; p++) {
			int y = p / N;
			int x = p % N;

			if (visited[y][x] || board[y][x] != 0)
				continue;

			cnt++;
			dq.offer(new int[] { y, x });
			rst++;
			visited[y][x] = true;

			while (!dq.isEmpty()) {
				int[] yx = dq.poll();

				for (int i = 0; i < 4; i++) {
					int ny = yx[0] + dy[i];
					int nx = yx[1] + dx[i];

					if (isPossable(ny, nx) && !visited[ny][nx] && board[ny][nx] == 0) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
						rst++;
					}
				}

				if (dq.isEmpty()) {
					cnts.add(rst);
				}
			}

			rst = 0;
		}

		return cnt;
	}

	public static boolean isPossable(int y, int x) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

}
