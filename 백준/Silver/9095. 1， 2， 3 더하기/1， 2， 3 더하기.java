import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());
		while(repeat-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int [12];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for(int i = 4; i <= N; i++) {
				dp[i] += dp[i - 1];
				dp[i] += dp[i - 2];
				dp[i] += dp[i - 3];
			}
			System.out.println(dp[N]);	
		}
	}
}