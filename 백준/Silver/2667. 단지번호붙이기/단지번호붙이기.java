import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int N;
	static boolean[][] board;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++)
				board[i][j] = input[j] == '0' ? false : true;
		}

		bfs();

		System.out.println(sb);
	}

	public static void bfs() {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int fullcnt = 0;
		for (int t = 0; t < N * N; t++) {
			int y = t / N;
			int x = t % N;

			if (visited[y][x] || !board[y][x])
				continue;

			Deque<int[]> dq = new ArrayDeque<>();
			dq.offer(new int[] { y, x });
			visited[y][x] = true;
			int cnt = 1;
			fullcnt++;
			while (!dq.isEmpty()) {
				int[] now = dq.poll();

				for (int i = 0; i < 4; i++) {
					int ny = now[0] + dy[i];
					int nx = now[1] + dx[i];

					if (isPossible(ny, nx) && !visited[ny][nx] && board[ny][nx]) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
						cnt++;
					}
				}
			}

			pq.offer(cnt);
		}

		sb.append(fullcnt).append("\n");
		while (!pq.isEmpty())
			sb.append(pq.poll()).append("\n");
	}

	public static boolean isPossible(int y, int x) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

}