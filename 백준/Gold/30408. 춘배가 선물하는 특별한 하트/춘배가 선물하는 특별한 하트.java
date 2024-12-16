import java.util.*;
import java.io.*;

public class Main {

	private static final Set<Long> map = new HashSet<>();
	private static long M = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
			
		yesOrNo(N);
		
		if(map.contains(M)) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}
		
		bw.close();
		br.close();
	}
	
	private static void yesOrNo(long N) {
		if(map.contains(N)) return;
		
		map.add(N);
		
		if(N == 1 || N <= M) return;
		
		if(N%2 == 0) {
			yesOrNo(N/2);
		} else {
			yesOrNo((N-1)/2);
			yesOrNo((N+1)/2);
		}
	}
	
}
