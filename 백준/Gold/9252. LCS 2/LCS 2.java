import java.util.*;
import java.io.*;
public class Main {
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		dp = new int[A.length + 1][B.length + 1];
		int[] idxArr = new int[A.length - 1];
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[A.length][B.length]);
		if (dp[A.length][B.length] != 0) {
			sb.append("\n");
			char[] lcs = new char[dp[A.length][B.length]];
			int idx = dp[A.length][B.length] - 1;
			int i = A.length, j = B.length;
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