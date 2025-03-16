import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int num = calculateXY(N);
		// System.out.println(num);
		
		int A = 1;
		int B = num;
		for(double i = num*num/2.0 + num/2.0; i > N; i--) {
			A++;
			B--;
		}
		
		if(num%2 != 0) { // up
			// up 이면 넓이의 가장 마지막숫자의 값을 알 수 있음
			// 따라서 up은 마지막 수가 [0][num] 임 -> 이 뜻은 1/num 부터라는 뜻
			
			
			
			System.out.println(A+"/"+B);
			
			
		} else { // down
			// num/1 부터 숫자가 줄어듦
			
			System.out.println(B+"/"+A);
			
		}
	}

	public static int calculateXY(int N) {
		int i = 0;
		for (i = 0; i * i / 2.0 + i / 2.0 < N; i++) {
		}

		return i;
	}
}