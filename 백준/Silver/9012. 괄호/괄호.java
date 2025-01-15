import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			Deque<Character> stack = new ArrayDeque<>();
			char[] input = br.readLine().toCharArray();
			boolean sen = false;
			for(char c : input) {
				if(c == '(') {
					stack.push(c);
				} else {
					if(stack.isEmpty()) {
						sen = true;
						break;
					}
					stack.pop();
				}
			}
			if(sen) sb.append("NO\n");
			else {
				if(!stack.isEmpty()) sb.append("NO\n");
				else sb.append("YES\n");	
			}
		}
		
		System.out.println(sb);
	}
	
}
