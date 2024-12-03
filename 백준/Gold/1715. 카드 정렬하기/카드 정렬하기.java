import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int totalSum = 0;
		while(pq.size() > 1) {
			int temp = pq.poll() + pq.poll();
			totalSum += temp;
			pq.add(temp);
		}
		
		System.out.println(totalSum);
		
		br.close();
	}
}