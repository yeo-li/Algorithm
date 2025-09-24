import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		board = new boolean[N][N];

		dfs(0, N - 1, 0, N - 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j])
					sb.append("*");
				else
					sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void dfs(int ys, int ye, int xs, int xe) {
		if (ys == ye && xs == xe) {
			board[ys][xs] = true;
			return;
		}

		int len = (ye - ys + 1) / 3;

		int ycnt = 0, xcnt = 0;
		for (int i = ys; i <= ye; i += len) {
			ycnt++;
			xcnt = 0;
			for (int j = xs; j <= xe; j += len) {
				xcnt++;
				if (ycnt == 2 && xcnt == 2)
					continue;
				dfs(i, i + len - 1, j, j + len - 1);
			}
		}
	}
}
