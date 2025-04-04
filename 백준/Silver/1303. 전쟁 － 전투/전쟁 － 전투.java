import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int N, M, B, W;
	static char[][] board;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[M][N];

		for (int i = 0; i < M; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++)
				board[i][j] = input[j];
		}

		bfs();

		System.out.println(W + " " + B);
		

	}

	public static void bfs() {
		boolean[][] visited = new boolean[M][N];

		for (int t = 0; t < N * M; t++) {
			Deque<int[]> dq = new ArrayDeque<>();
			int y = t / N;
			int x = t % N;

			if (visited[y][x])
				continue;

			char color = board[y][x];

			int cnt = 1;
			dq.offer(new int[] { y, x });
			visited[y][x] = true;
			while (!dq.isEmpty()) {
				int[] now = dq.poll();

				for (int i = 0; i < 4; i++) {
					int ny = now[0] + dy[i];
					int nx = now[1] + dx[i];

					if (isValid(ny, nx) && !visited[ny][nx] && color == board[ny][nx]) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
						cnt++;
					}
				}
			}

			if (color == 'W')
				W += cnt * cnt;
			else
				B += cnt * cnt;
		}

	}

	public static boolean isValid(int y, int x) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

}