import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] Tree;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();

		StringBuilder sb = new StringBuilder();
		for (char c : input) {
			sb.append(Character.toUpperCase(c));
		}

		System.out.println(sb);
	}

}