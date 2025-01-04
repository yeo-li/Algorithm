import java.util.*;
import java.io.*;


public class Main {
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] isPrime = new boolean[1001];
		for(int i = 2; i <= 1000; i++) {
			isPrime[i] = true;
		}
		
		for(int i = 2; i <= 1000; i++) {
			if(!isPrime[i]) continue;
			for(int j = 2; j*i <= 1000; j++) {
				isPrime[j*i] = false;
			}
		}
		
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int rst = 0;
		for(int i = 0; i < N; i++) {
			if(isPrime[numbers[i]]) {
				rst++;
			}
		}
		
		System.out.println(rst);
	}
	
	
}