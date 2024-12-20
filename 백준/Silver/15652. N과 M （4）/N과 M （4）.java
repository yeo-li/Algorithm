import java.util.*;
import java.io.*;

public class Main {
	static int N = 0;
	static int M = 0;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		rNM(1, 0);
		System.out.println(result.toString());
	}
	
	private static void rNM(int num, int depth) {
		if(depth == M) {
			for(char a: sb.toString().toCharArray()) {
				result.append(a + " ");
			}
			result.append("\n");
			return;
		}
		
		for(int i = num; i <= N; i++) {
			sb.append(i);
			rNM(i, depth + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
