import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();
		
		int cnt = 0;
		int ans = 0;
		for(int i = 0; i < M - 2;) {
			if(S[i] == 'I' && S[i+1] == 'O' && S[i+2] == 'I') {
				i+=2;
				cnt++;
				if(cnt == N) {
					ans++;
					cnt--;
				}
			} else {
				i++;
				cnt = 0;
			}
		}
		
		System.out.println(ans);
	}
	
}