import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if(cmd.equals("pop")) {
				if(stack.isEmpty()) sb.append(-1).append("\n");
				else sb.append(stack.pop()).append("\n");
			} else if(cmd.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if(cmd.equals("empty")) {
				if(stack.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			} else if(cmd.equals("top")) {
				if(stack.isEmpty()) sb.append(-1).append("\n");
				else sb.append(stack.peek()).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
}