import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] dp = new int[str.length()+1];
		StringBuilder str2 = new StringBuilder(str);
		

		dp[0] = 0;
		for(int i = 1; i <= str.length(); i++) {
			dp[i] = dp[i-1] + 1;
			for(int j = i-1; j >= 0; j--) {
				if(isPalindrome(str, j, i-1)) {
					if(dp[i] > dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
		}
		
		System.out.println(dp[str.length()]);
		
		br.close();
	}
	
	
	public static boolean isPalindrome(String str, int j, int i) {
		int left = j;
		int right = i;
		
		while(left < right) {
			if(str.charAt(left) == str.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		
		return true;
	}
	
}