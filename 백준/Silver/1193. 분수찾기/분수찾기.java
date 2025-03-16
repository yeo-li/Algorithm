import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int num = 0;
		for (num = 0; num * num / 2.0 + num / 2.0 < N; num++) {
		}

		int A = 1;
		int B = num;
		for(double i = num*num/2.0 + num/2.0; i > N; i--) {
			A++;
			B--;
		}
		
		if(num%2 != 0) { 
			System.out.println(A+"/"+B);
		} else { 
			System.out.println(B+"/"+A);
			
		}
	}

}