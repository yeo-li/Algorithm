import java.util.*;
import java.io.*;

public class Main {
	static int Y, X;
	static boolean[][] board, visited;
	static int[][] dis;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		board = new boolean[Y][X];
		visited = new boolean[Y][X];
		dis = new int[Y][X];
		
		for(int i = 0; i < Y; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < X; j++) {
				if(input[j] == '0') board[i][j] = false;
				else board[i][j] = true;
			}
		}
		
		bfs();
		
		System.out.println(dis[Y-1][X-1]);
	}
	
	public static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		dis[0][0] = 1;
		dq.offer(new int[] {0, 0});
		while(!dq.isEmpty()) {
			int[] xy = dq.poll(); // 여기서부터 파생되어 온 친구임.
			// 상하좌우 탐색
			for(int i = 0; i < 4; i++) {
				int ny = xy[0] + dy[i];
				int nx = xy[1] + dx[i];
				// board 를 넘지 않으면서, 지나갈 수 있는 길이라면
				if(isVaild(ny, nx) && board[ny][nx]) {
					if(dis[ny][nx] != 0 && dis[ny][nx] <= dis[xy[0]][xy[1]] + 1) continue;
					else {
						dq.offer(new int[] {ny, nx});	
						dis[ny][nx] = dis[xy[0]][xy[1]] + 1;
					}
				}
			}
		}
		
	}
	
	public static boolean isVaild(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}
	
}