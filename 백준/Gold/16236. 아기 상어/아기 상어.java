import java.util.*;
import java.io.*;

public class Main {
	static int N, size;
	static int[][] board;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = 2;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solve());
	}

	public static int solve() {
		int time = 0;
		int food = 0;
		while (true) {
			int[] now = bfs();
			if (now == null) {
				break;
			}
			time += now[2];
			food++;
			board[now[0]][now[1]] = 9;
			if (size == food) {
				size++;
				food = 0;
			}
		}

		return time;
	}

	public static int[] bfs() {
		boolean[][] visited = new boolean[N][N];

		Deque<int[]> dq = new ArrayDeque<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] != o2[2])
				return o1[2] - o2[2];
			if (o1[0] != o2[0])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});

		for (int p = 0; p < N * N; p++) {
			int y = p / N;
			int x = p % N;
			if (board[y][x] == 9) {
				dq.offer(new int[] { y, x, 0 });
				board[y][x] = 0;
				visited[y][x] = true;
				break;
			}
		}

		while (!dq.isEmpty()) {
			int[] yx = dq.poll();
			if (board[yx[0]][yx[1]] < size && board[yx[0]][yx[1]] != 0) {
				pq.offer(yx);
			}

			for (int i = 0; i < 4; i++) {
				int ny = yx[0] + dy[i];
				int nx = yx[1] + dx[i];
				if (isPossible(ny, nx) && !visited[ny][nx]) {
					dq.offer(new int[] { ny, nx, yx[2] + 1 });
					visited[ny][nx] = true;
				}
			}
		}

		return pq.poll();
	}

	public static boolean isPossible(int y, int x) {
		return 0 <= x && x < N && 0 <= y && y < N && board[y][x] <= size;
	}

}