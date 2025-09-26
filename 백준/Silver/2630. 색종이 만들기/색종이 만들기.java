import java.util.*;
import java.io.*;

public class Main {
	static int N, white = 0, blue = 0;
	static boolean[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				board[i][j] = st.nextToken().equals("1");
		}

		dfs(0, 0, N);

		System.out.println(white + "\n" + blue);
	}

	public static void dfs(int y, int x, int length) {
		if (isSameColor(y, x, length)) {
			if (board[y][x])
				blue++;
			else
				white++;
			return;
		}

		int len = length / 2;
		dfs(y, x, len);
		dfs(y + len, x, len);
		dfs(y, x + len, len);
		dfs(y + len, x + len, len);

	}

	public static boolean isSameColor(int y, int x, int length) {
		boolean color = board[y][x];
		for (int i = y; i < y + length; i++) {
			for (int j = x; j < x + length; j++) {
				if (color != board[i][j])
					return false;
			}
		}
		return true;
	}

}
