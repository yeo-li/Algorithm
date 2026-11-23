import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int rst = 0;
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			rst += solution(word) ? 1 : 0;
		}

		System.out.println(rst);
	}

	public static boolean solution(String word) {

		Set<Character> chars = new HashSet<>();

		char[] arr = word.toCharArray();
		char prev = arr[0];
		chars.add(prev);
		for (int i = 1; i < arr.length; i++) {
			if (prev != arr[i] && chars.contains(arr[i])) {
				return false;
			}
			chars.add(arr[i]);
			prev = arr[i];
		}

		return true;
	}

}