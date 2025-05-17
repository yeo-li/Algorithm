import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(Character.toString(input[j]));
			}
		}

		int len = Math.max(N, M) - 1;
		while (len >= 0) {
			for (int i = 0; i < N - len; i++) {
				for (int j = 0; j < M - len; j++) {
					if (isSame(arr[i][j], arr[i + len][j + len], arr[i + len][j], arr[i][j + len])) {
						System.out.println((len + 1) * (len + 1));
						return;
					}
				}
			}
			len--;
		}
	}

	public static boolean isSame(int p1, int p2, int p3, int p4) {
		return p1 == p2 && p2 == p3 && p3 == p4;
	}

}