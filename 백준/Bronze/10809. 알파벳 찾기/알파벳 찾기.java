import java.util.*;
import java.io.*;

public class Main {

	static Map<Character, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 'a'; i <= 'z'; i++) {
			map.put((char)i, -1);
		}
		
		char[] input = br.readLine().toCharArray();
		
		for(int i = 0 ; i < input.length; i++) {
			if(map.get(input[i]) == -1) {
				map.put(input[i], i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char a: map.keySet()) {
			sb.append(map.get(a)).append(" ");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
}
