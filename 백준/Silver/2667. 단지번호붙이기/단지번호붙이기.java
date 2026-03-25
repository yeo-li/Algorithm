import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int N;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(String.valueOf(input[j]));
		}

		bfs();

		System.out.println(sb);
	}

	public static void bfs() {
		boolean[][] visited = new boolean[N][N];
		Deque<int[]> dq = new ArrayDeque<>();
		int cnt = 0;
		List<Integer> rst = new ArrayList<>();
		for (int p = 0; p < N * N; p++) {
			int y = p / N;
			int x = p % N;

			if (visited[y][x] || board[y][x] == 0)
				continue;

			dq.offer(new int[] { y, x });
			visited[y][x] = true;
			cnt++;

			int weight = 1;
			while (!dq.isEmpty()) {
				int[] yx = dq.poll();

				for (int i = 0; i < 4; i++) {
					int ny = yx[0] + dy[i];
					int nx = yx[1] + dx[i];

					if (isPossible(ny, nx) && !visited[ny][nx]) {
						dq.offer(new int[] { ny, nx });
						weight++;
						visited[ny][nx] = true;
					}
				}
			}

			rst.add(weight);
		}

		Collections.sort(rst);
		sb.append(cnt).append("\n");
		for (int num : rst)
			sb.append(num).append("\n");
	}

	public static boolean isPossible(int y, int x) {
		return 0 <= x && x < N && 0 <= y && y < N && board[y][x] != 0;
	}
}