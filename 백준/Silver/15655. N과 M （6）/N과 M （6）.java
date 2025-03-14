import java.util.*;
import java.io.*;

public class Main {
	
	static int N = 0;
	static int M = 0;
	static List<Integer> arr;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		
		rNM(0, "", new boolean[N]);
		System.out.println(result.toString());
	}
	
	private static void rNM(int depth, String str, boolean[] dp) {
		if(depth == M) {
			for(char c: str.toCharArray())
				result.append(arr.get(Integer.parseInt(String.valueOf(c))) + " ");
			result.append("\n");
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		
		for(int i = 0; i < N; i++) {
			if(dp[i]) continue;
			sb.append(i);
			dp[i] = true;
			rNM(depth+1, sb.toString(), dp.clone());
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
