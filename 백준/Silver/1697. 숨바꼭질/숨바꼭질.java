import java.util.*;
import java.io.*;

public class Main {
	static int N, K, ans = 0;
	static int[] arr = new int[100_001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= 100_000; i++)
			arr[i] = Integer.MAX_VALUE;

		if (N != K) {
			bfs();
			System.out.println(arr[K]);
		} else
			System.out.println(0);

	}

	public static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();

		dq.offer(new int[] { N, 0 });

		while (!dq.isEmpty()) {
			int[] xd = dq.poll();

			if (xd[0] == K)
				return;

			int nx = xd[0] - 1;
			if (isPossable(nx) && arr[nx] > xd[1] + 1) {
				dq.offer(new int[] { nx, xd[1] + 1 });
				arr[nx] = xd[1] + 1;
			}

			nx = xd[0] + 1;
			if (isPossable(nx) && arr[nx] > xd[1] + 1) {
				dq.offer(new int[] { nx, xd[1] + 1 });
				arr[nx] = xd[1] + 1;
			}

			nx = xd[0] * 2;
			if (isPossable(nx) && arr[nx] > xd[1] + 1) {
				dq.offer(new int[] { nx, xd[1] + 1 });
				arr[nx] = xd[1] + 1;
			}
		}
	}

	public static boolean isPossable(int x) {
		return 0 <= x && x <= 100_000;
	}

}
