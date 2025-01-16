import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		char[] Pn = createPn(N).toCharArray();
		
		int cnt = 0;
		for(int i = 0; i < input.length - Pn.length + 1; i++) {
			boolean isPn = true;
			for(int j = 0; j < Pn.length; j++) {
				if(input[i + j] != Pn[j]) {
					isPn = false;
					break;
				}
			}
			
			if(isPn) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static String createPn(int N) {
		StringBuilder sb = new StringBuilder();
		sb.append("I");
		for(int i = 0; i < N; i++) 
			sb.append("OI");
		
		return sb.toString();
	}
}