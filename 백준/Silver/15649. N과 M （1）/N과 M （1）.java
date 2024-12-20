import java.util.*;
import java.io.*;

public class Main {
	static final StringBuilder sb = new StringBuilder();
	static int N = 0;
	static int M = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		rNM(0);
	} 
	
	private static void rNM(int depth) {
		if(depth == M) {
			for(int i = 0; i < M ;i++) {
				System.out.print(sb.toString().charAt(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(sb.toString().contains(String.valueOf(i))) continue;
			sb.append(i);
			rNM(depth + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
