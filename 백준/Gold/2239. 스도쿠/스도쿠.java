import java.util.*;
import java.io.*;

public class Main {
	static int[][] board = new int[9][9];
	static List<int[]> zeros = new ArrayList<>();
	static boolean flag = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = null;
		for (int i = 0; i < 9; i++) {
			input = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(String.valueOf(input[j]));
				if (board[i][j] == 0)
					zeros.add(new int[] { i, j });
			}

		}

		dfs(0, 0);

		System.out.println(sb);

	}

	public static void dfs(int depth, int start) {
		if (depth == zeros.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			flag = true;
			return;
		}

		int[] yx = zeros.get(start);

		for (int i = 1; i <= 9; i++) {
			if (flag)
				return;

			if (isPossable(yx[0], yx[1], i)) {
				board[yx[0]][yx[1]] = i;
				dfs(depth + 1, start + 1);
				board[yx[0]][yx[1]] = 0;
			}
		}
	}

	public static boolean isPossable(int y, int x, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[i][x] == num)
				return false;
		}

		for (int i = 0; i < 9; i++) {
			if (board[y][i] == num)
				return false;
		}

		int startY = 0;
		int startX = 0;
		if (y < 3) {
			startY = 0;
		} else if (3 <= y && y < 6) {
			startY = 3;
		} else {
			startY = 6;
		}

		if (x < 3) {
			startX = 0;
		} else if (3 <= x && x < 6) {
			startX = 3;
		} else {
			startX = 6;
		}

		for (int i = startY; i < startY + 3; i++) {
			for (int j = startX; j < startX + 3; j++) {
				if (board[i][j] == num)
					return false;
			}
		}

		return true;
	}

}