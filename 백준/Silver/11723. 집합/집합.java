import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int set = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String method = st.nextToken();

			if (method.equals("add"))
				add(Integer.parseInt(st.nextToken()));
			else if (method.equals("remove"))
				remove(Integer.parseInt(st.nextToken()));
			else if (method.equals("check"))
				check(Integer.parseInt(st.nextToken()));
			else if (method.equals("toggle"))
				toggle(Integer.parseInt(st.nextToken()));
			else if (method.equals("all"))
				all();
			else if (method.equals("empty"))
				empty();
		}

		System.out.println(sb);
	}

	public static void add(int x) {
		set |= 1 << x;
	}

	public static void remove(int x) {
		set &= ~(1 << x);
	}

	public static void check(int x) {
		int A = set & (1 << x);
		int B = 1 << x;
		if (A == B)
			sb.append(1);
		else
			sb.append(0);
		sb.append("\n");
	}

	public static void toggle(int x) {
		int A = set & (1 << x);
		int B = 1 << x;

		if (A == B)
			remove(x);
		else
			add(x);
	}

	public static void all() {
		set = ~0;
	}

	public static void empty() {
		set = 0;
	}

}
