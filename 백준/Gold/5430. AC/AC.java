import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(N-- > 0) {
			char[] func = br.readLine().toCharArray();
			int len = Integer.parseInt(br.readLine());
			Deque<Integer> arr = new ArrayDeque<>();
			String tmp = br.readLine();
			tmp = tmp.substring(1, tmp.length() - 1);
			String[] input = tmp.split(",");
			for(int i = 0; i < len; i++) {
				arr.add(Integer.parseInt(input[i]));
			}
			
			boolean isHeader = true;
			boolean sensor = false;
			for(char cmd : func) {
				if(cmd == 'R') {
					isHeader = !isHeader;
				} else {
					if(arr.isEmpty()) {
						sensor = true;
						break;
					}
					if(isHeader) arr.poll();
					else arr.pollLast();
				}
			}
			
			if(sensor) sb.append("error\n");
			else {
				sb.append("[");
				
				if(isHeader) {
					if(!arr.isEmpty()) {
						sb.append(arr.poll());
					}
					while(!arr.isEmpty())
						sb.append(",").append(arr.poll());
				} else {
					if(!arr.isEmpty()) {
						sb.append(arr.pollLast());	
					}
					while(!arr.isEmpty())
						sb.append(",").append(arr.pollLast());
				}
				sb.append("]").append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}
}