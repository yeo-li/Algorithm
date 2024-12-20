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
		
		rNM(0);
		System.out.println(result.toString());
	}
	
	private static void rNM(int depth) {
		if(depth == M) {
			for(char c : sb.toString().toCharArray())
				result.append(nums[Integer.parseInt(String.valueOf(c))] + " ");
			result.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(sb.toString().contains(String.valueOf(i)) && numbers.get(nums[i]) == 0)
				continue;
			sb.append(i);
			numbers.put(nums[i], numbers.get(nums[i]) - 1);
			rNM(depth + 1);
			sb.deleteCharAt(sb.length() - 1);
			numbers.put(nums[i], numbers.get(nums[i]) + 1);
		}
	}
	
}
