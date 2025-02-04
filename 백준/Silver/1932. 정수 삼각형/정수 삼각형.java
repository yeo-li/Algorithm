import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<long[]> tri = new ArrayList<>();
		List<long[]> dp = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long[] arr = new long[i];
			dp.add(new long[i]);
			for (int j = 0; j < i; j++) {
				arr[j] = Long.parseLong(st.nextToken());
			}
			tri.add(arr);
		}

		// bottom - up
		for (int i = 0; i < N; i++)
			dp.get(N - 1)[i] = tri.get(N - 1)[i];

		for (int i = N - 2; i >= 0; i--) { // 층
			for (int j = 0; j < dp.get(i).length; j++) {
				dp.get(i)[j] = Math.max(dp.get(i+1)[j], dp.get(i+1)[j+1]) + tri.get(i)[j];
			}
		}
		
		System.out.println(dp.get(0)[0]);

	}

}
