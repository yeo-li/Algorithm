import java.util.*;
import java.io.*;

public class Main {
	
	static int N = 0;
	static int M = 0;
	static Integer[] nums;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder result = new StringBuilder();
	static TreeMap<Integer, Integer> numbers = new TreeMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i ++) {
			int key = Integer.parseInt(st.nextToken());
			numbers.put(key, numbers.getOrDefault(key, 0) + 1);
		}
			
		N = numbers.size();
		nums = numbers.keySet().toArray(new Integer[0]);
		Arrays.sort(nums);
		
		rNM(0, new boolean[N]);
		System.out.println(result.toString());
	}
	
	private static void rNM(int depth, boolean[] dp) {
		if(depth == M) {
			for(char c : sb.toString().toCharArray())
				result.append(nums[Integer.parseInt(String.valueOf(c))] + " ");
			result.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(dp[i]) continue;
			sb.append(i);
			rNM(depth + 1, dp.clone());
			dp[i] = true;
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
}
