import java.util.*;
import java.io.*;

public class Main {
	static int[][] board = new int[3][3];
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());

	}

	public static int bfs() {
		Set<String> visited = new HashSet<>();
		visited.add(createKey());

		Deque<String> dq = new ArrayDeque<>();
		dq.offer(createKey());

		int cnt = 0;
		while (!dq.isEmpty()) {
			int size = dq.size();

			for (int p = 0; p < size; p++) {
				String pz = dq.poll();
				if (pz.equals("123456780"))
					return cnt;

				int zero = pz.indexOf("0");

				int y = zero / 3;
				int x = zero % 3;

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (!isPossible(ny, nx))
						continue;

					char[] ar = pz.toCharArray();
					ar[y * 3 + x] = ar[ny * 3 + nx];
					ar[ny * 3 + nx] = '0';

					if (!visited.contains(String.valueOf(ar))) {
						dq.offer(new String(ar));
						visited.add(new String(ar));
					}

				}
			}
			cnt++;
		}

		return -1;
	}

	public static String createKey() {
		String rst = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				rst += String.valueOf(board[i][j]);
		}
		return rst;
	}

	public static boolean isPossible(int y, int x) {
		return 0 <= x && x < 3 && 0 <= y && y < 3;
	}

}