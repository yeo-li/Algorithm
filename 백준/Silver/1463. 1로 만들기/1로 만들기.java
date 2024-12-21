import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		bw.write(String.valueOf(recursive(N)));
		bw.close();
	}
	
	private static int recursive(int N) {
		if(N == 1) return 0;
		
		if(dp[N] == 0) {
			if(N % 6 == 0) {
				dp[N] = Math.min(recursive(N - 1), Math.min(recursive(N/3), recursive(N/2))) + 1;
			} else if(N%3 == 0) {
				dp[N] = Math.min(recursive(N/3), recursive(N-1)) + 1;
			} else if(N % 2 == 0) {
				dp[N] = Math.min(recursive(N/2), recursive(N-1)) + 1;
			} else {
				dp[N] = recursive(N-1) + 1;
			}
		}
		
		return dp[N];
	}
}
