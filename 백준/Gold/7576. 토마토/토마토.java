import java.util.*;
import java.io.*;

public class Main {
	static int[][] box, visited;
	static int N, M;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Deque<int[]> dq = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];

		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = -1;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					dq.offer(new int[] { i, j });
					visited[i][j] = 0;
				}

			}
		}

		bfs();

		System.out.println(calculateTomatoes());

	}

	public static int calculateTomatoes() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0)
					return -1;
				if (max < visited[i][j])
					max = visited[i][j];
			}
		}

		return max;

	}

	public static void bfs() {

		while (!dq.isEmpty()) {
			int[] yx = dq.poll();

			for (int i = 0; i < 4; i++) {
				int ny = yx[0] + dy[i];
				int nx = yx[1] + dx[i];

				if (isPossable(ny, nx) && visited[ny][nx] == -1) {
					dq.offer(new int[] { ny, nx });
					visited[ny][nx] = visited[yx[0]][yx[1]] + 1;
					box[ny][nx] = 1;
				}
			}
		}
	}

	public static boolean isPossable(int y, int x) {
		return 0 <= x && x < M && 0 <= y && y < N && box[y][x] != -1;
	}

}