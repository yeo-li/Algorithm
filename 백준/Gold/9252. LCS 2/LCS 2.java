
// import java.util.*;
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
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		dp = new int[A.length + 1][B.length + 1];
		for (i = 1; i <= A.length; i++) {
			for (j = 1; j <= B.length; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		sb = new StringBuilder();
		sb.append(dp[A.length][B.length]);
		if (dp[A.length][B.length] != 0) {
			sb.append("\n");
			lcs = new char[dp[A.length][B.length]];
			idx = dp[A.length][B.length] - 1;
			i = A.length;
			j = B.length;
			while (i > 0 && j > 0) {
				if (A[i - 1] == B[j - 1]) {
					lcs[idx] = A[i - 1];
					i--;
					j--;
					idx--;
				} else {
					if (dp[i - 1][j] > dp[i][j - 1]) {
						i--;
					} else {
						j--;
					}
				}
			}
			for (char c : lcs)
				sb.append(c);
		}
		System.out.println(sb);
	}

}