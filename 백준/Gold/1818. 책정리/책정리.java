import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] books = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			books[i] = Integer.parseInt(st.nextToken());

		int[] LIS = new int[N];
		int len = 0;
		for (int i = 0; i < N; i++) {
			int l = 0, r = len - 1;
			while (l <= r) {
				int mid = (l + r) / 2;
				if (LIS[mid] < books[i])
					l = mid + 1;
				else
					r = mid - 1;
			}

			LIS[l] = books[i];
			if (l == len)
				len++;
		}

		System.out.println(N - len);
	}
}