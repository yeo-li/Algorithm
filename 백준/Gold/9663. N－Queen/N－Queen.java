import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] col;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		col = new int[N];

		dfs(0);

		System.out.println(cnt);
	}

	public static void dfs(int row) {
		if (row == N) {
			cnt++;
			return;
		}
		for (int c = 0; c < N; c++) {
			col[row] = c;

			if (isPossible(row)) {
				dfs(row + 1);
			}
		}
	}

	public static boolean isPossible(int row) {
		for (int i = 0; i < row; i++) {
			if (col[i] == col[row]) {
				return false;
			}

			if (Math.abs(row - i) == Math.abs(col[row] - col[i])) {
				return false;
			}
		}
		return true;
	}

}