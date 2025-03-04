import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] G;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		G = new List[N + 1];
		for (int i = 1; i <= N; i++)
			G[i] = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (v == 1) {
					G[i].add(j);
					union(i, j);
				}
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] travel = new int[M];
		for (int i = 0; i < M; i++) {
			travel[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M - 1; i++) {
			if (find(travel[i]) != find(travel[i + 1])) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");

	}

	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			parent[rootY] = rootX;
		}
	}

	public static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

}