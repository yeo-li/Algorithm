import java.util.*;
import java.io.*;

public class Main {
	static Map<Integer, List<Integer>> G = new HashMap<>();
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++)
			G.put(i, new ArrayList<>());

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			G.get(v1).add(v2);
			G.get(v2).add(v1);
		}
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int node) {
		for(int v : G.get(node)) {
			if(parents[v] != 0) continue;
			
			parents[v] = node;
			dfs(v);
		}
	}
}
