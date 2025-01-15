import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Long> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			set.add(Long.parseLong(st.nextToken()));
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			long num = Long.parseLong(st.nextToken());
			if(set.contains(num)) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
