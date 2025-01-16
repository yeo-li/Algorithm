import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> dic = new HashMap<>();
		Map<String, Integer> dic2 = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			String p = br.readLine();
			dic.put(i, p);
			dic2.put(p, i);
		}
		
		StringBuilder sb = new StringBuilder();
		boolean sensor = true;
		for(int i = 0; i < M; i++) {
			sensor = true;
			String input = br.readLine();
			if(isNumber(input)) {
				sb.append(dic.get(Integer.parseInt(input))).append("\n");
			} else {
				sb.append(dic2.get(input)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static boolean isNumber(String input) {
		for(char c : input.toCharArray())
			if(!Character.isDigit(c)) return false;
		return true;
	}
}