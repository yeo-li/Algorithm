import java.util.*;
import java.io.*;

public class Main {
	static int I;
	static int[][] board;
	static int[] start = new int[2];
	static int[] end = new int[2];
	static int[][] dyx = { { 2, -1 }, { 2, 1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { -2, -1 }, { -2, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int r = 0; r < N; r++) {
			I = Integer.parseInt(br.readLine());

			board = new int[I][I];
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < I; j++) {
					board[i][j] = Integer.MAX_VALUE;
				}
			}

			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());

			sb.append(bfs()).append("\n");
		}

		System.out.println(sb);
	}

	public static int bfs() {
		Deque<int[]> dq = new ArrayDeque<>();

		dq.offer(new int[] { start[0], start[1], 0 }); // y, x, depth
		board[start[0]][start[1]] = 0;

		while (!dq.isEmpty()) {
			int[] xy = dq.poll();
			for (int i = 0; i < 8; i++) {
				int ny = xy[0] + dyx[i][0];
				int nx = xy[1] + dyx[i][1];

				if (isPossable(ny, nx) && board[ny][nx] > (xy[2] + 1)) {
					dq.offer(new int[] { ny, nx, xy[2] + 1 });
					board[ny][nx] = xy[2] + 1;
				}
			}
		}

		return board[end[0]][end[1]];
	}

	public static boolean isPossable(int y, int x) {
		return 0 <= x && x < I && 0 <= y && y < I;
	}

}