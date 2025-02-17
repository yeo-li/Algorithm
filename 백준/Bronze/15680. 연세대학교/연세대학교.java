import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] Tree;

	static int maxDepth, maxChild;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//
//		maxDepth = 0;
//		maxChild = 0;
//
//		Tree = new List[N + 1];
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			Tree[i] = new ArrayList<>();
//			int v = Integer.parseInt(st.nextToken());
//			if (i == 0)
//				continue;
//			Tree[v].add(i);
//		}
//
//		dfs(0, 0);
//		if (maxDepth != 1) {
//			findMaxChild(0, 0);
//		} else {
//			maxChild = 1;
//		}
//
////		for (int node : Tree[0]) {
////			maxDepth++;
////		}
////		maxDepth--;
//
//		System.out.println(maxDepth + maxChild - 1);
		
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.println("Leading the Way to the Future");
		} else {
			System.out.println("YONSEI");	
		}
		
		

	}

	public static void dfs(int v, int depth) {
		for (int node : Tree[v]) {
			dfs(node, depth + 1);
		}

		if (Tree[v].isEmpty()) {
			maxDepth = Math.max(depth, maxDepth);
		}
	}

	public static void findMaxChild(int v, int depth) {
		int cnt = 0;

		for (int node : Tree[v]) {
			cnt++;
			findMaxChild(node, depth + 1);
		}

		if (depth == maxDepth - 1) {
			maxChild = Math.max(maxChild, cnt);
		}

	}

}