import java.util.*;
import java.io.*;

public class Main {
	static char[] word;
	static char[] result;
	static boolean[] chae;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		chae = new boolean[1000001];
		int cnt = 0;
		for(int i = 2; i <= 1000; i++) {
			if(chae[i]) continue;
			for(int j = 2; j*i < 1000000; j++) {
				if(chae[j*i]) {
					continue;
				}
				cnt++;
				chae[j*i] = true;
			}
		}
		// System.out.println(cnt);
		int[] primes = new int[1000001 - cnt];
		int idx = 0;
		for(int i = 2; i <= 1000000; i++) {
			if(isPrime(i)) {
				primes[idx] = i;
				idx++;
			}
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			sb.append(N + " = ");
			
			for(int i = 0; i < primes.length; i++) {
				if(N < primes[i]) {
					System.out.println("Goldbach's conjecture is wrong.");
					break;
				}
				
				if(isPrime(N - primes[i])) {
					sb.append(primes[i] + " + " + (N - primes[i]));
					break;
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	
	private static boolean isPrime(int N) {
		return !chae[N];
	}
}
