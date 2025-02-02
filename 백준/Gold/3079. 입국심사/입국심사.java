import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] simsa = new long[N];
		long max = 0;
		for (int i = 0; i < N; i++) {
			simsa[i] = Long.parseLong(br.readLine());
			max = Math.max(max, simsa[i]);
		}

		Arrays.sort(simsa);

		long low = 0, high = M * max;
		long rst = Long.MAX_VALUE;
		while (low <= high) {
			long mid = (low + high) / 2;
			long sum = 0;
			for (long idx : simsa) {
				if (sum >= M)
					break;
				long cnt = mid / idx;

				sum += cnt;
			}

			if (sum >= M) {
				high = mid - 1;
				rst = Math.min(mid, rst);
			} else {
				low = mid + 1;
			}
		}

		System.out.println(rst);
	}
}
