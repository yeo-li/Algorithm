import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int N;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int maxHeight = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, board[i][j]);
			}
		}
		
		int rst = 1;
		for(int i = 1; i <= maxHeight; i++) {
			rst = Math.max(rst, bfs(i));
		}

		System.out.println(rst);
	}

	public static int bfs(int rain) {
		int cnt = 0;
		boolean[][] visited = new boolean[N][N];
		Deque<int[]> dq = new ArrayDeque<>();

		for (int p = 0; p < N * N; p++) {
			int y = p / N;
			int x = p % N;

			if (visited[y][x] || !isPossable(y, x, rain))
				continue;

			cnt++;
			dq.offer(new int[] { y, x });
			visited[y][x] = true;

			while (!dq.isEmpty()) {
				int[] now = dq.poll();

				for (int i = 0; i < 4; i++) {
					int ny = now[0] + dy[i];
					int nx = now[1] + dx[i];

					if (isPossable(ny, nx, rain) && !visited[ny][nx]) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
					}
				}
			}
		}

		return cnt;
	}

	public static boolean isPossable(int y, int x, int rain) {
		return 0 <= x && x < N && 0 <= y && y < N && board[y][x] > rain;
	}

}
