import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N + 1];

		dfs(0);
	}

	public static void dfs(int depth) {
		if (depth >= M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++)
				sb.append(arr[i] + " ");
			System.out.println(sb);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;
			
			visited[i] = true;
			arr[depth] = i;
			dfs(depth + 1);
			visited[i] = false;
		}
	}

}
