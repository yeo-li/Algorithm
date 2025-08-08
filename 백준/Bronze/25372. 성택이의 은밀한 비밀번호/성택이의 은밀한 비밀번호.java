import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String pw = br.readLine();
			if (6 <= pw.length() && pw.length() <= 9)
				sb.append("yes\n");
			else
				sb.append("no\n");
		}

		System.out.println(sb);
	}

}