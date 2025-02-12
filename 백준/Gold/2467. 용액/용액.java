import java.util.*;
import java.io.*;

public class Main {
	static int[] L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		L = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			L[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(L);

		int[] ans = new int[2];
		int min = Integer.MAX_VALUE;

		int l = 0, r = N - 1;
		while (l < r) {
			int sum = L[l] + L[r];

			if (min > Math.abs(sum)) {
				min = Math.abs(L[r] + L[l]);
				ans[0] = L[r];
				ans[1] = L[l];
			}
			
			if(sum <= 0) l++;
			else r--;
		}
		
		Arrays.sort(ans);
		System.out.println(ans[0] + " " + ans[1]);
	}

}