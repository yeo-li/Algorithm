import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;
	static char[] A, B;
	static StringBuilder sb;
	static char[] lcs;
	static int idx, i, j;
	static BufferedReader br;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] position = new int[N + 1][2];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			position[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}

		position[N][0] = position[0][0];
		position[N][1] = position[0][1];

		long a = 0, b = 0;
		for (int i = 0; i < N; i++) {
			a += (long) position[i][0] * position[i + 1][1];
			b += (long) position[i][1] * position[i + 1][0];
		}

		double rst = Math.abs(a - b) / 2.0;
		System.out.printf("%.1f\n", rst);

	}

	public static double calculate(int[] p1, int[] p2, int[] p3) {
		return ((p2[0] - p1[0]) * (p3[1] - p1[1]) - (p3[0] - p1[0]) * (p2[1] - p1[1])) / 2.0;
	}
}