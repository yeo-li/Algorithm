import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//
//		int[] arr = new int[N];
//		int[] dp = new int[K + 1];
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		
//		for(int i = 1; i <= K; i++) {
//			
//		}

		StringBuilder sb = new StringBuilder();
		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				break;
			int rst = 0;
			for(int i = 1; i <= num; i++) {
				rst += i;
			}
			sb.append(rst + "\n");
		}
		
		System.out.println(sb);

	}
}
