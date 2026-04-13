import java.util.*;
import java.io.*;

public class Main {
	static int[][] board = new int[9][9];
	static int N = 0;
	static List<int[]> pos = new ArrayList<>();
	static boolean end = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					N++;
					pos.add(new int[] { i, j });
				}
			}
		}

		dfs(0);

		System.out.println(sb);
	}

	public static void dfs(int idx) {
		if (idx == N) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					sb.append(board[i][j]).append(" ");
				sb.append("\n");
			}
			end = true;
			return;
		}

		int[] yx = pos.get(idx);

		for (int i = 1; i <= 9; i++) {
			if (isPossible(idx, i)) {
				board[yx[0]][yx[1]] = i;
				dfs(idx + 1);
			}
			if (end)
				return;
			board[yx[0]][yx[1]] = 0;
		}
	}

	public static boolean isPossible(int idx, int num) {
		int[] yx = pos.get(idx);
		int y = 0;
		int x = 0;

		for (int i = 0; i < 9; i++) {
			if (board[i][yx[1]] == num || board[yx[0]][i] == num)
				return false;
		}

		if (yx[0] < 3)
			y = 0;
		else if (yx[0] < 6)
			y = 3;
		else
			y = 6;

		if (yx[1] < 3)
			x = 0;
		else if (yx[1] < 6)
			x = 3;
		else
			x = 6;

		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++)
				if (board[i][j] == num)
					return false;
		}

		return true;
	}

}