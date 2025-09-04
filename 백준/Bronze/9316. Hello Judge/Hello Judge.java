import java.util.*;
import java.io.*;

public class Main {
	static char[][] board;
	static int N, M;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int[] red = { 0, 0 }, blue = { 0, 0 }, hole = { 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//
//		board = new char[N][M];
//
//		for (int i = 0; i < N; i++) {
//			board[i] = br.readLine().toCharArray();
//			for (int j = 0; j < M; j++) {
//				if (board[i][j] == 'R') {
//					red[0] = i;
//					red[1] = j;
//				} else if (board[i][j] == 'B') {
//					blue[0] = i;
//					blue[1] = j;
//				} else if (board[i][j] == '0') {
//					hole[0] = i;
//					hole[1] = j;
//				}
//			}
//		}

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			System.out.printf("Hello World, Judge %d!\n", i);
		}

	}

//	static class Capture {
//		public char[][] board;
//		public int depth;
//
//		public Capture(char[][] board, int depth) {
//			this.board = copy(board);
//			this.depth = depth;
//		}
//
//		private char[][] copy(char[][] board) {
//			char[][] arr = new char[board.length][board[0].length];
//			for (int i = 0; i < board.length; i++) {
//				for (int j = 0; j < board[0].length; j++) {
//					arr[i][j] = board[i][j];
//				}
//			}
//
//			return arr;
//		}
//	}
//
//	public static void bfs() {
//		Deque<Capture> dq = new ArrayDeque<>();
//
//		dq.offer(new Capture(board, 0));
//
//		for (int p = 0; p < 10; p++) {
//			if (dq.isEmpty()) {
//				return;
//			}
//
//			Capture cp = dq.poll();
//			char[][] board = cp.board;
//			
//			
//		}
//	}
//
//	public static boolean moveMarble(char[][] board, int direction) {
//		int ry = red[0] + dy[direction];
//		int rx = red[1] + dx[direction];
//		int by = blue[0] + dy[direction];
//		int bx = blue[1] + dx[direction];
//
//		while (isPossable(ry, rx) && board[ry][rx] != '#' && isPossable(by, bx) && board[]) {
//			
//		}
//		
//		
//		return false;
//	}
//
//	public static boolean isPossable(int y, int x) {
//		return 0 <= x && x < N && 0 <= y && y < M;
//	}
//	

}
