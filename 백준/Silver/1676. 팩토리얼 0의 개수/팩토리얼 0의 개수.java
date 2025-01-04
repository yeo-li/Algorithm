import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		BigInteger num = new BigInteger("1");
		
		for(int i = 1; i <= N; i++) {
			BigInteger num2 = new BigInteger(String.valueOf(i));
			num = num.multiply(num2);
		}
		
		String str = num.toString();
		int cnt = 0;
		for(int i = str.length() - 1; i >= 0; i--) {
			if(str.charAt(i) == '0') cnt++;
			else break;
		}
		
		System.out.println(cnt);
	}
	
}