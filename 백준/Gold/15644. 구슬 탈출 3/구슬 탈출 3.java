import java.util.*;
import java.io.*;

public class Main {
	static char[][] board;
	static int N, M;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int[] red = { 0, 0 }, blue = { 0, 0 }, hole = { 0, 0 };
	static char[] direct = { 'L', 'R', 'U', 'D' };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
				} else if (board[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
				} else if (board[i][j] == 'O') {
					hole[0] = i;
					hole[1] = j;
				}
			}
		}

		System.out.println(bfs());
		System.out.println(sb);

	}

	static class Capture {
		public int depth;
		public int[] red;
		public int[] blue;
		public List<Integer> path;

		public Capture(int depth, int[] red, int[] blue, List<Integer> path) {
			this.depth = depth;
			this.red = red;
			this.blue = blue;
			this.path = new ArrayList<>(path);
		}

	}

	public static int bfs() {
		Deque<Capture> dq = new ArrayDeque<>();

		dq.offer(new Capture(0, new int[] { red[0], red[1] }, new int[] { blue[0], blue[1] }, new ArrayList<>()));

		while (true) {
			if (dq.isEmpty())
				break;
			Capture cp = dq.poll();
			if (cp.depth == 10)
				break;

			for (int i = 0; i < 4; i++) {
				Capture ncp = new Capture(cp.depth + 1, new int[] { cp.red[0], cp.red[1] },
						new int[] { cp.blue[0], cp.blue[1] }, cp.path);
				int result = moveMarble(ncp, i);
				if (result == 0 && !isSame(cp, ncp)) {
					dq.offer(ncp);
				} else if (result == 1) {
					return ncp.depth;
				}

			}
		}

		return -1;
	}

	public static int moveMarble(Capture cp, int direction) {
		int ry = cp.red[0];
		int rx = cp.red[1];
		int by = cp.blue[0];
		int bx = cp.blue[1];

		boolean flag = false;
		while (true) {
			if (by == hole[0] && bx == hole[1])
				return -1;

			if (ry == hole[0] && rx == hole[1]) {
				ry = board.length;
				rx = board[0].length;
				flag = true;
			}

			int nry = ry + dy[direction];
			int nrx = rx + dx[direction];
			int nby = by + dy[direction];
			int nbx = bx + dx[direction];

			if (isPossable(nry, nrx) || isPossable(nby, nbx)) {

				if (isPossable(nry, nrx) && isPossable(nby, nbx)) {
					ry = nry;
					rx = nrx;

					by = nby;
					bx = nbx;
				} else if (isPossable(nry, nrx) && !isPossable(nby, nbx)) {
					if (nry == by && nrx == bx)
						break;

					ry = nry;
					rx = nrx;

				} else if (!isPossable(nry, nrx) && isPossable(nby, nbx)) {
					if (ry == nby && rx == nbx)
						break;
					by = nby;
					bx = nbx;
				}

			} else {
				break;
			}
		}

		if (flag) {
			for (int d : cp.path)
				sb.append(direct[d]);
			sb.append(direct[direction]);
			return 1;
		}

		cp.path.add(direction);

		board[cp.red[0]][cp.red[1]] = '.';
		board[cp.blue[0]][cp.blue[1]] = '.';
		board[ry][rx] = 'R';
		board[by][bx] = 'B';

		cp.red[0] = ry;
		cp.red[1] = rx;

		cp.blue[0] = by;
		cp.blue[1] = bx;

		return 0;
	}

	public static boolean isPossable(int y, int x) {
		return 0 <= x && x < M && 0 <= y && y < N && board[y][x] != '#';
	}

	public static char[][] copy(char[][] board) {
		char[][] arr = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				arr[i][j] = board[i][j];
			}
		}

		return arr;
	}

	public static boolean isSame(Capture cp1, Capture cp2) {
		if (cp1.red[0] == cp2.red[0] && cp1.red[1] == cp2.red[1] && cp1.blue[0] == cp2.blue[0]
				&& cp1.blue[1] == cp2.blue[1])
			return true;

		return false;
	}

}
