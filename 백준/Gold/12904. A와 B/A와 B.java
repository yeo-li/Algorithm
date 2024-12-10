import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 뒤에 A를 추가한다
		// 문자열을 뒤집고 뒤에 B를 추가한다.
		// 반복한다(?)
		
		String S = br.readLine();
		String T = br.readLine();
		StringBuilder sb = new StringBuilder(T);
		
		while(sb.length() > S.length()) {
			if(sb.charAt(sb.length() - 1) == 'A') {
				sb.deleteCharAt(sb.length() - 1);
			} else if(sb.charAt(sb.length() - 1) == 'B') {
				sb.deleteCharAt(sb.length() - 1);
				sb.reverse();
			}
		}
		
		if(S.equals(sb.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
		br.close();
	}

}