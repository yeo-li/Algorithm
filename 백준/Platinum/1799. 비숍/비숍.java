import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] board;
	static int ans0 = 0, ans1 = 0, N;
	static boolean[] right, left;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		board = new boolean[N * 2 - 1][N * 2 - 1];
		right = new boolean[N * 2 - 1];
		left = new boolean[N * 2 - 1];

		for (int i = 0; i < N; i++) {
			int l = i;
			int r = N - 1 - i;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[l + j][r + j] = st.nextToken().equals("1");
			}
		}

		dfs(0, 0, Math.abs(N - 1), 0);
		dfs(0, 0, Math.abs(N - 1), 1);

		System.out.println(ans0 + ans1);

	}

	public static void dfs(int l, int cnt, int start, int color) {

		if (color == 0) {
			ans0 = Math.max(ans0, cnt);
			if (cnt + 2 * N - 1 - l <= ans0)
				return;
		} else {
			ans1 = Math.max(ans1, cnt);
			if (cnt + 2 * N - 1 - l <= ans1)
				return;
		}

		dfs(l + 1, cnt, Math.abs(start - 1), color);

		if (l % 2 != color)
			return;

		for (int r = start; r < 2 * N - 1 - start; r++) {
			if (board[l][r] && isPossable(l, r)) {
				left[l] = true;
				right[r] = true;
				dfs(l + 1, cnt + 1, Math.abs(start - 1), color);
				left[l] = false;
				right[r] = false;
			}
		}
	}

	public static boolean isPossable(int l, int r) {
		return !left[l] && !right[r];
	}

}
