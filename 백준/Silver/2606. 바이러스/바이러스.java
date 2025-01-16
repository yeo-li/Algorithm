import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] graph;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		graph = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		while(M-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			// connect
			graph[node1][node2] = true;
			graph[node2][node1] = true;
		}
		
		System.out.println(bfs(1));
		
	}
	
	public static int bfs(int start) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(start);
		visited[start] = true;
		
		int cnt = 0;
		while(!dq.isEmpty()) {
			int node = dq.poll();
			
			for(int i = 1; i <= N; i++) {
				if(graph[i][node] && !visited[i]) {
					cnt++;
					dq.offer(i);
					visited[i] = true;
				}
			}
		}
		
		return cnt;
	}
}