import java.util.*;
import java.io.*;

public class Main {
	static boolean[] isSelfNumber = new boolean[10_001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i += 4) {
			sb.append("long ");
		}
		
		sb.append("int");
		
		System.out.println(sb);

	}

}
