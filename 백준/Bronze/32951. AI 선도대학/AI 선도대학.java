import java.util.*;
import java.io.*;

public class Main {
	static int[][] planet;
	static int[] parent, rank;
	static List<int[]> edgeList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		planet = new int[N][3];
//		edgeList = new ArrayList<>();
//		parent = new int[N * 3];
//		rank = new int[N * 3];
//		for (int i = 0; i < N * 3; i++) {
//			parent[i] = i;
//			rank[i] = 1;
//		}
//
//		for (int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			planet[i][0] = Integer.parseInt(st.nextToken());
//			planet[i][1] = Integer.parseInt(st.nextToken());
//			planet[i][2] = Integer.parseInt(st.nextToken());
//		}
//
//		Arrays.sort(planet, (o1, o2) -> o1[0] - o2[0]);
//		for (int i = 0; i < N - 1; i++) {
//			int w = Math.abs(planet[i][0] - planet[i + 1][0]);
//
//			edgeList.add(new int[] { i, i + 1, w });
//		}
//
//		Arrays.sort(planet, (o1, o2) -> o1[1] - o2[1]);
//		for (int i = 0; i < N - 1; i++) {
//			int w = Math.abs(planet[i][0] - planet[i + 1][0]);
//
//			edgeList.add(new int[] { i, i + 1, w });
//		}
//
//		Arrays.sort(planet, (o1, o2) -> o1[2] - o2[2]);
//		for (int i = 0; i < N - 1; i++) {
//			int w = Math.abs(planet[i][2] - planet[i + 1][2]);
//
//			edgeList.add(new int[] { i, i + 1, w });
//		}
//
//		Collections.sort(edgeList, (o1, o2) -> o1[2] - o1[2]);
//
//		int rst = 0;
//		for (int i = 0; i < edgeList.size(); i++) {
//
//		}

		int N = Integer.parseInt(br.readLine());

		System.out.println(N - 2024);

	}

	public static int find(int x) {
		if (parent[x] != x)
			parent[x] = find(parent[x]);
		return parent[x];
	}

	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			parent[rootX] = rootY;
			// TODO : rank 코드 짜기
		}
	}

}