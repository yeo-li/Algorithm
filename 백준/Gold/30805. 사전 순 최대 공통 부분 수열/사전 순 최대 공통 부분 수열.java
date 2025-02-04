import java.util.*;
import java.io.*;

public class Main {
	static long C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			B[i] = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] != o2[0])
				return o2[0] - o1[0];
			if (o1[1] != o2[1]) {
				return o1[1] - o2[1];
			}
			return o1[2] - o2[2];
		});

		boolean[][] dp = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] = A[i] == B[j];
				if (dp[i][j])
					pq.add(new int[] { B[j], i, j });
			}
		}

		List<Integer> arr = new ArrayList<>();
		int[] tmp = { -1, -1, -1 };
		while (!pq.isEmpty()) {
			int[] nums = pq.poll();
			
			if (!(tmp[1] < nums[1] && tmp[2] < nums[2]))
				continue;

			tmp[0] = nums[0];
			tmp[1] = nums[1];
			tmp[2] = nums[2];
			arr.add(nums[0]);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(arr.size()).append("\n");
		for (int a : arr)
			sb.append(a).append(" ");

		System.out.println(sb);

	}

}
