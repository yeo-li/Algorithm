import java.util.*;
import java.io.*;

public class Main {
	static int N, C;
	static int[] house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for (int i = 0; i < N; i++)
			house[i] = Integer.parseInt(br.readLine());
		Arrays.sort(house);

		long lo = 0;
		long hi = Integer.MAX_VALUE;
		while (lo + 1 < hi) {
			long mid = (lo + hi) / 2;
			if (check(mid))
				lo = mid;
			else
				hi = mid;
		}
		
		System.out.println(lo);
	}

	public static boolean check(long mid) {
		int current = 0;
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (house[i] - house[current] >= mid) {
				cnt++;
				current = i;
			}
			if (cnt >= C)
				return true;
		}
		return cnt >= C;
	}

}
