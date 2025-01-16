import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] graph;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			graph[n1][n2] = true;
			graph[n2][n1] = true;
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		int cnt = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				cnt++;
				dq.offer(i);
				visited[i] = true;
			}
			while(!dq.isEmpty()) {
				int node = dq.poll();
				for(int j = 1; j <= N; j++) {
					if(graph[node][j] && !visited[j]) {
						dq.offer(j);
						visited[j] = true;
					}
				}
			}
		}
		
		return cnt;
	}
	
}