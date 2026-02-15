import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static boolean[][] board;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수

		board = new boolean[N + 1][M + 1];

		// 음식물이 떨어진 좌표(r, c)
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = true;
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		int max = 0;
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][M + 1];

		for (int p = 1; p <= N * M; p++) {
			int y = p / (M + 1) + 1;
			int x = p % M + 1;

			if (visited[y][x] || !board[y][x])
				continue;

			dq.offer(new int[] { y, x });
			visited[y][x] = true;
			int rst = 1;

			while (!dq.isEmpty()) {
				int[] now = dq.poll();

				for (int i = 0; i < 4; i++) {
					int ny = now[0] + dy[i];
					int nx = now[1] + dx[i];

					if (isPossable(ny, nx) && !visited[ny][nx] && board[ny][nx]) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
						rst++;
					}
				}
			}

			max = Math.max(max, rst);
		}

		return max;
	}

	public static boolean isPossable(int y, int x) {
		return 1 <= x && x <= M && 1 <= y && y <= N;
	}

}
