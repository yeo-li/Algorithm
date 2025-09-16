import java.util.*;
import java.io.*;

public class Main {
	static int N, white = 0, blue = 0;
	static boolean[][] paper;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		N = Integer.parseInt(br.readLine());
//		paper = new boolean[N][N];
//		for (int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < N; j++)
//				paper[i][j] = st.nextToken().equals("1");
//		}
//		
//		bfs();
//		
//		System.out.println(white + "\n" + blue);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		for(int i = 0; i < 3;i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < 3;i ++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void bfs() {
		boolean[][] visited = new boolean[N][N];
		Deque<int[]> dq = new ArrayDeque<>();

		for (int p = 0; p < N * N; p++) {
			int y = p / N;
			int x = p % N;

			if (visited[y][x])
				continue;

			if (paper[y][x])
				white++;
			else
				blue++;

			dq.offer(new int[] { y, x });

			while (!dq.isEmpty()) {
				int[] yx = dq.poll();

				for (int i = 0; i < 4; i++) {
					int ny = yx[0] + dy[i];
					int nx = yx[1] + dx[i];

					if(isPossable(ny, nx) && !visited[ny][nx] && paper[y][x] == paper[ny][nx]) {
						dq.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					}
				}
			}

		}
	}

	public static boolean isPossable(int y, int x) {
		return 0 <= y && y < N && 0 <= x & x < N;
	}

}
