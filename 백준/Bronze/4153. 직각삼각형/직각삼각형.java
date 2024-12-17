import java.util.*;
import java.io.*;

public class Main {

	static Map<Character, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String input = br.readLine();
			if(input.charAt(0) == '0') break;
			
			StringTokenizer st = new StringTokenizer(input);
			
			
			boolean result = isTriangle(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			if(result) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
		
		br.close();
	}
	
	
	private static boolean isTriangle(int a, int b, int c) {
		return a*a + b*b == c*c || a*a == b*b + c*c || b*b == a*a + c*c;
	}
}
