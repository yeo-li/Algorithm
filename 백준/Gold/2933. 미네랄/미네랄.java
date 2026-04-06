import java.util.*;
import java.io.*;

public class Main {
	static int R, C;
	static boolean[][] board;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++)
				board[i][j] = String.valueOf(input[j]).equals("x");
		}

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		boolean isLeft = true;
		while (N-- > 0) {
			int H = Integer.parseInt(st.nextToken());
			detroy(H, isLeft);
			bfs();
			isLeft = !isLeft;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				sb.append(board[i][j] ? "x" : ".");
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void detroy(int height, boolean isLeft) {
		int start = isLeft ? 0 : C - 1;
		int end = isLeft ? C - 1 : 0;
		int delta = isLeft ? 1 : -1;

		if (isLeft) {
			for (int i = start; i <= end; i += delta) {
				if (board[R - height][i]) {
					board[R - height][i] = false;
					return;
				}
			}
			return;
		}

		for (int i = start; i >= end; i += delta) {
			if (board[R - height][i]) {
				board[R - height][i] = false;
				return;
			}
		}

	}

	public static void bfs() {
		boolean[][] visited = new boolean[R][C];
		Deque<int[]> dq = new ArrayDeque<>();

		// 바닥에 붙 있는 클러스더 모두 방문 처리
		for (int i = 0; i < C; i++) {
			if (isPossible(R - 1, i) && !visited[R - 1][i] && board[R - 1][i]) {
				dq.offer(new int[] { R - 1, i });
				visited[R - 1][i] = true;
			}

			while (!dq.isEmpty()) {
				int[] yx = dq.poll();

				for (int j = 0; j < 4; j++) {
					int ny = yx[0] + dy[j];
					int nx = yx[1] + dx[j];

					if (isPossible(ny, nx) && !visited[ny][nx] && board[ny][nx]) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
					}
				}
			}
		}

		// 공중에 떠있는 클러스터 찾기
		boolean[][] cluster = new boolean[R + 1][C + 1];
		for (int p = 0; p < R * C; p++) {
			int y = p / C;
			int x = p % C;

			if (isPossible(y, x) && board[y][x] && !cluster[y][x] && !visited[y][x]) {
				dq.offer(new int[] { y, x });
				cluster[y][x] = true;
			}

			while (!dq.isEmpty()) {
				int[] yx = dq.poll();

				for (int j = 0; j < 4; j++) {
					int ny = yx[0] + dy[j];
					int nx = yx[1] + dx[j];

					if (isPossible(ny, nx) && board[ny][nx] && !cluster[ny][nx] && !visited[y][x]) {
						dq.offer(new int[] { ny, nx });
						cluster[ny][nx] = true;
					}
				}
			}
		}

		// 모든 클러스터를 수직으로 내려 거리가 가장 가까운 클러스터 찾기
		int min = Integer.MAX_VALUE;
		for (int p = 0; p < R * C; p++) {
			int y = p / C;
			int x = p % C;

			if (cluster[y][x]) {
				int dis = 0;
				for (int i = y; i < R; i++) {
					if (visited[i][x])
						break;
					dis++;
				}
				min = Math.min(min, dis);
			}
		}

		// 공중에 떠있는 클러스터 모두 수직으로 내리기
		for (int y = R - 1; y >= 0; y--) {
			for (int x = 0; x < C; x++) {
				if (cluster[y][x]) {
					board[y][x] = false;
					board[y + min - 1][x] = true;
				}
			}
		}
	}

	public static boolean isPossible(int y, int x) {
		return 0 <= x && x < C && 0 <= y && y < R;
	}
}