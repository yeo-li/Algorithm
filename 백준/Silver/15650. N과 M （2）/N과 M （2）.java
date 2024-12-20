import java.util.*;
import java.io.*;

public class Main {
	static int N = 0;
	static int M = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		rNM(0, new boolean[N]);
	}
	
	private static void rNM(int depth, boolean[] dp) {
		if(depth == M) {
			for(char a: sb.toString().toCharArray()) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
		for(int i = depth + 1; i <= N; i++) {
			if(dp[i-1]) continue;
			dp[i - 1] = true;
			sb.append(i);
			rNM(depth + 1, dp.clone());
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
