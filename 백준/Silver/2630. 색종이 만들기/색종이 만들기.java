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

		dfs(new int[] { 0, 0 }, N);

		System.out.println(white + "\n" + blue);
	}

	public static void dfs(int[] start, int length) {
		if (isSameColor(start, length)) {
			if (board[start[0]][start[1]])
				blue++;
			else
				white++;
			return;
		}

		int len = length / 2;
		dfs(new int[] { start[0], start[1] }, len);
		dfs(new int[] { start[0] + len, start[1] }, len);
		dfs(new int[] { start[0], start[1] + len }, len);
		dfs(new int[] { start[0] + len, start[1] + len }, len);
	}

	public static boolean isSameColor(int[] start, int length) {

		boolean color = board[start[0]][start[1]];
		for (int i = start[0]; i < start[0] + length; i++) {
			for (int j = start[1]; j < start[1] + length; j++) {
				if (color != board[i][j])
					return false;
			}
		}

		return true;
	}

}
