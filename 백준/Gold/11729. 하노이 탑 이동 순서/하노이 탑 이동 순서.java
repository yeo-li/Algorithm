import java.util.*;
import java.io.*;

public class Main {
	static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		sb.append((int) Math.pow(2, N) - 1).append("\n");
		dfs(N, 1, 2, 3);
		System.out.println(sb);
	}

	public static void dfs(int n, int from, int via, int to) {
		if (n == 1) {
			sb.append(from + " " + to).append("\n");
			return;
		}

		dfs(n - 1, from, to, via);
		sb.append(from + " " + to).append("\n");
		dfs(n - 1, via, from, to);
	}

}