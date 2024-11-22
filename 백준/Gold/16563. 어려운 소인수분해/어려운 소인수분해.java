import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[500001];
		for(int i = 2; i <= 500000; i++) arr[i] = true;
		
		List<Integer> primes = new ArrayList<>();

		for(int i = 2; i <= Math.sqrt(500000); i++) {
			if(arr[i]) {
				for(int j = i*i; j <= 500000; j += i) {
					arr[j] = false;
				}
			}
			
		}
		
		for(int i = 2; i <= 500000; i++) {
			if(arr[i]) {
				primes.add(i);
			}
			
		}
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreElements()) {
			int number = Integer.parseInt(st.nextToken());
			int M = number;
			for(int prime: primes) {
				if ( prime * prime > M) break;
				while(M % prime == 0) {
					bw.write(prime + " ");
					M /= prime;
				}
			}
			
			if(M > 1) bw.write(M + " ");
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
