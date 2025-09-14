import java.util.*;
import java.io.*;

public class Main {
	static boolean[] isSelfNumber = new boolean[10_001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			sb.append(br.readLine().toLowerCase()).append("\n");
		}
		
		System.out.println(sb);
	}

}
