import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(String.valueOf(input[j]));
			}
		}

		dfs(0, 0, N);

		System.out.println(sb);
	}

	public static void dfs(int y, int x, int len) {
		if (isSameColor(y, x, len)) {
			sb.append(board[y][x]);
			return;
		}

		sb.append("(");

		dfs(y, x, len / 2);
		dfs(y, x + len / 2, len / 2);
		dfs(y + len / 2, x, len / 2);
		dfs(y + len / 2, x + len / 2, len / 2);

		sb.append(")");
	}

	public static boolean isSameColor(int y, int x, int len) {

		int color = board[y][x];
		for (int i = y; i < y + len; i++) {
			for (int j = x; j < x + len; j++) {
				if (color != board[i][j])
					return false;
			}
		}

		return true;
	}

}