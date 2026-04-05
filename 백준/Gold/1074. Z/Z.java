import java.util.*;
import java.io.*;

public class Main {
	static int r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		dfs(0, N, 0, 0);

		System.out.println();
	}

	public static void dfs(int w, int n, int x, int y) {
		if (!(y <= r && r < y + (int) Math.pow(2, n) && x <= c && c < x + (int) Math.pow(2, n))) {
			return;
		}

		if (y == r && x == c) {
			System.out.println(w);
			return;
		}

		int sq = (int) Math.pow(2, n - 1);

		dfs(w, n - 1, x, y);
		dfs(w + sq * sq, n - 1, x + sq, y);
		dfs(w + 2 * sq * sq, n - 1, x, y + sq);
		dfs(w + 3 * sq * sq, n - 1, x + sq, y + sq);

		return;
	}
}