import java.util.*;
import java.io.*;


public class Main {
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] money = new int[N];
		for(int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i = N - 1; i >= 0 ; i--) {
			while(true) {
				if(money[i] > K) break;
				K -= money[i];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}