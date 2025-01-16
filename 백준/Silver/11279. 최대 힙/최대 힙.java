import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.isEmpty())sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			} else {
				pq.add(num);
			}
		}
		
		System.out.println(sb);
	}
	
}