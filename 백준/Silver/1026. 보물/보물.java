import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			B.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(A);
		Collections.sort(B, (o1, o2) -> o2 - o1);
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans += A.get(i)*B.get(i);
		}
		
		System.out.println(ans);
		
	}

}
