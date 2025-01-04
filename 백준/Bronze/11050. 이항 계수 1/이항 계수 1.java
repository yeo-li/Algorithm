import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int num1 = 1;
		for(int i = 1; i <= N; i++) {
			num1 *= i;
		}
		int num2 = 1;
		for(int i = 1; i <= M; i++) {
			num2 *= i;
		}
		int num3 = 1;
		for(int i = 1; i <= N - M; i++) {
			num3 *= i;
		}
		
		System.out.println(num1/(num2*num3));
	}
	
}