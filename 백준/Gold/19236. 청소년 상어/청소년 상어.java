import java.util.*;
import java.io.*;

public class Main {
	static int[][][] board = new int[4][4][2];
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int ans;
	static int[][] fishes = new int[17][2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				board[i][j][0] = Integer.parseInt(st.nextToken());
				board[i][j][1] = Integer.parseInt(st.nextToken()) - 1;

				fishes[board[i][j][0]][0] = i;
				fishes[board[i][j][0]][1] = j;
			}
		}

		fishes[board[0][0][0]][0] = -1;
		fishes[board[0][0][0]][1] = -1;
		int num = board[0][0][0];
		int nDirection = board[0][0][1];
		board[0][0][0] = 0;
		board[0][0][1] = 0;

		dfs(num, nDirection, 0, 0);

		System.out.println(ans);
	}

	public static void dfs(int score, int direction, int y, int x) {
		ans = Math.max(score, ans);

		moveFishes(y, x);
		int[][][] now = copy(board);
		int[][] nowFishes = copyFishes(fishes);

		int ny = y + dy[direction];
		int nx = x + dx[direction];
		while (isPossable(ny, nx)) {
			board = copy(now);
			fishes = copyFishes(nowFishes);

			if (board[ny][nx][0] != 0) {
				int num = board[ny][nx][0];
				int nDirection = board[ny][nx][1];
				fishes[board[ny][nx][0]][0] = -1;
				fishes[board[ny][nx][0]][1] = -1;
				board[ny][nx][0] = 0;
				board[ny][nx][1] = 0;

				dfs(score + num, nDirection, ny, nx);
			}

			ny += dy[direction];
			nx += dx[direction];
		}
	}

	public static boolean isPossable(int y, int x) {
		return 0 <= y && y < 4 && 0 <= x && x < 4;
	}

	public static void moveFishes(int y, int x) {
		for (int i = 1; i <= 16; i++) {
			int[] yx = fishes[i];
			if (yx[0] < 0)
				continue;

			int direction = board[yx[0]][yx[1]][1];

			for (int j = 0; j < 8; j++) {
				int nd = (direction + j) % 8;
				int ny = yx[0] + dy[nd];
				int nx = yx[1] + dx[nd];

				if (!isPossable(ny, nx) || (ny == y && nx == x))
					continue;

				if (board[ny][nx][0] == 0) {

					board[ny][nx][0] = board[yx[0]][yx[1]][0];
					board[ny][nx][1] = nd;

					board[yx[0]][yx[1]][0] = 0;
					board[yx[0]][yx[1]][1] = 0;

					fishes[board[ny][nx][0]][0] = ny;
					fishes[board[ny][nx][0]][1] = nx;

				} else {
					int fy = yx[0], fx = yx[1];

					int other = board[ny][nx][0];
					int otherDir = board[ny][nx][1];

					int tmp1, tmp2;
					tmp1 = board[fy][fx][0];
					tmp2 = nd;
					board[fy][fx][0] = other;
					board[fy][fx][1] = otherDir;
					board[ny][nx][0] = tmp1;
					board[ny][nx][1] = tmp2;

					fishes[board[ny][nx][0]][0] = ny;
					fishes[board[ny][nx][0]][1] = nx;

					fishes[board[fy][fx][0]][0] = fy;
					fishes[board[fy][fx][0]][1] = fx;
				}

				break;
			}
		}
	}

	public static int[][][] copy(int[][][] ar) {
		int[][][] arr = new int[4][4][2];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j][0] = ar[i][j][0];
				arr[i][j][1] = ar[i][j][1];
			}
		}
		return arr;
	}

	public static int[][] copyFishes(int[][] ar) {
		int[][] arr = new int[17][2];

		for (int i = 1; i <= 16; i++) {
			arr[i][0] = ar[i][0];
			arr[i][1] = ar[i][1];
		}

		return arr;
	}

}