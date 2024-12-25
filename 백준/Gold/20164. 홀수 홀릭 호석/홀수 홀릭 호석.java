import java.util.*;
import java.io.*;


public class Main {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		rDivideNumber(br.readLine(), 0);
		
		System.out.println(min + " " + max);
	}
	
	private static void rDivideNumber(String number, int result) {
		
		if(number.length() == 1) { // 한자리라면
			min = Math.min(min, result + isOdd(Integer.parseInt(number)));
			max = Math.max(max, result + isOdd(Integer.parseInt(number)));
			
		} else if(number.length() == 2) { // 두자리라면
			int A = Integer.parseInt(number.substring(0, 1));
			int B = Integer.parseInt(number.substring(1, 2));
			rDivideNumber(String.valueOf(A+B), result + isOdd(A) + isOdd(B));

		} else { // 세자리라면
			for(int i = 1; i < number.length(); i++) {
				for(int j = i + 1; j < number.length(); j++) {
					int A =  Integer.parseInt(number.substring(0, i));
					int B =  Integer.parseInt(number.substring(i, j));
					int C =  Integer.parseInt(number.substring(j, number.length()));
					
					rDivideNumber(String.valueOf(A+B+C), result + isOdd(A) + isOdd(B) + isOdd(C));
				}
			}
		}
		
	}
	
	private static int isOdd(int N) {
		if(N%2 == 1) {
			return 1;
		}
		return 0;
	}
	
}
