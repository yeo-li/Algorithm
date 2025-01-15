import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) 
			dq.addLast(i);
		
		int cnt = 1;
		while(dq.size() != 1) {
			if(cnt%2 != 0) {
				dq.poll();
			} else {
				int tmp = dq.poll();
				dq.addLast(tmp);
			}
			
			cnt++;
		}
		
		System.out.println(dq.poll());
	}
	
}
