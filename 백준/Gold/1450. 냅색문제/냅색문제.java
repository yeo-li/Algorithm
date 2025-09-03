import java.util.*;
import java.io.*;

public class Main {
	static long C;
	static long[] A, B;
	static List<Long> sumA = new ArrayList<>();
	static List<Long> sumB = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		A = new long[N / 2];
		B = new long[N - N / 2];

//		sumA.add(0L);
//		sumB.add(0L);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N / 2; i++)
			A[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N - N / 2; i++)
			B[i] = Integer.parseInt(st.nextToken());

		dfs(B, 0, 0, sumB);
		dfs(A, 0, 0, sumA);

		Collections.sort(sumA);
		Collections.sort(sumB);

		long ans = 0;
		for (int i = 0; i < sumA.size(); i++) {
			int l = 0;
			int r = sumB.size();

			while (l < r) {
				int mid = (l + r) / 2;
				if (sumB.get(mid) > C - sumA.get(i)) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}

			ans += l;
		}
//
//		if (C == 0) {
//			System.out.println(0);
//			return;
//		}

		System.out.println(ans);

	}

	public static void dfs(long[] arr, int start, long sum, List<Long> result) {
		if (sum > C)
			return;
		if (start == arr.length) {
			result.add(sum);
			return;
		}

		dfs(arr, start + 1, sum, result);
		dfs(arr, start + 1, sum + arr[start], result);
	}

}
