import java.util.*;
import java.io.*;

public class Main {
	static long N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Long.parseLong(br.readLine());
		K = Long.parseLong(br.readLine());

		long lo = 0;
		long hi = N * N;
		while (lo + 1 < hi) {
			long mid = (lo + hi) / 2;
			if (check(mid)) {
				hi = mid;
			} else {
				lo = mid;
			}
		}

		System.out.println(hi);
	}

	public static boolean check(long mid) {
		long cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += Math.min(N, mid / i);
			if (cnt >= K)
				return true;
		}
		return false;
	}
}
