import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[][] board, visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new boolean[N][M];
			visited = new boolean[N][M];
			int K = Integer.parseInt(st.nextToken());
			while(K-->0) {
				st  = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				board[y][x] = true;
			}
			
			sb.append(bfs()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int bfs() {
		int cnt = 0;
		Deque<int[]> dq = new ArrayDeque<>();
		for(int i = 0; i < N * M; i++) {
			int y = i / M;
			int x = i % M;
			if(board[y][x] && !visited[y][x]) {
				dq.offer(new int[] {y, x});
				visited[y][x] = true;
				cnt++;
			}
			
			while(!dq.isEmpty()) {
				int[] xy = dq.poll();
				for(int j = 0; j < 4; j++) {
					int ny = xy[0] + dy[j];
					int nx = xy[1] + dx[j];
					if(isValid(ny, nx) && !visited[ny][nx] && board[ny][nx]) {
						dq.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static boolean isValid(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M;
	}	
}