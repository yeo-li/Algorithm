import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<Character> keys = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			boolean bool = condition1(sb, str, keys);
			if(!bool) {
				condition2(sb, str, keys);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static boolean condition1(StringBuilder sb, String str, List<Character> keys) {
		boolean b = false;
		String[] words = str.split(" ");
		for(int i = 0; i < words.length; i++) {
			if(isPossible(Character.toUpperCase(words[i].charAt(0)), keys)) {
				keys.add(Character.toUpperCase(words[i].charAt(0)));
				words[i] = converter(words[i], 0);
				b = true;
				break;
			}
		}
		
		if(b) {
			sb.append(words[0]);
			for(int i = 1; i < words.length; i++) {
				sb.append(" ").append(words[i]);
			}
		}
		
		return b;
	}
	
	private static boolean condition2(StringBuilder sb, String str, List<Character> keys) {
		boolean b = false;
		String[] words = str.split(" ");
		for(int i = 0; i < words.length;i++) {
			for(int j = 0; j < words[i].length(); j++) {
				if(isPossible(Character.toUpperCase(words[i].charAt(j)), keys)) {
					keys.add(Character.toUpperCase(words[i].charAt(j)));
					words[i] = converter(words[i], j);
					b = true;
					i = words.length;
					break;
				}
			}
		}
		
		sb.append(words[0]);
		for(int i = 1; i < words.length; i++) {
			sb.append(" ").append(words[i]);
		}
		
		return b;
	}
	

	// char를 넣으면 사용 가능한지 boolean으로 반환
	private static boolean isPossible(char c, List<Character> keys) {
		for(char key:keys) {
			if(key == c) {
				return false;
			}
		}
		
		return true;
	}
	
	// string과 idx를 넣으면 그 부분에 [] 를 씌워서 반환
	private static String converter(String str, int idx) {
		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();
		
		for(int i = 0; i < str.length(); i++) {
			if(idx == i) {
				sb.append("[").append(arr[i]).append("]");
			} else {
				sb.append(arr[i]);
			}
		}
		
		return sb.toString();
	}
	

}