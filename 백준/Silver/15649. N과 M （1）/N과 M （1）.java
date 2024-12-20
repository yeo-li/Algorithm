import java.util.*;
import java.io.*;

public class Main {
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		rNM(N, M, sb);
	} 
	
	private static void rNM(int N, int M, StringBuilder sb) {
		if(sb.toString().length() == M) {
			for(int i = 0; i < M ;i++) {
				System.out.print(sb.toString().charAt(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(sb.toString().contains(String.valueOf(i))) continue;
			sb.append(i);
			rNM(N, M, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
