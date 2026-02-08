import java.util.*;
import java.io.*;

public class Main {
	static Map<String, List<String>> G = new HashMap<>();
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String A = st.nextToken();
			String B = st.nextToken();
			String C = st.nextToken();

			if (G.get(A) == null)
				G.put(A, new ArrayList<>());
			if (G.get(B) == null && !B.equals("."))
				G.put(B, new ArrayList<>());
			if (G.get(C) == null && !C.equals("."))
				G.put(C, new ArrayList<>());

			G.get(A).add(B);
			G.get(A).add(C);
		}

		preorder("A");
		sb.append("\n");
		inorder("A");
		sb.append("\n");
		postorder("A");

		System.out.println(sb);
	}

	public static void preorder(String parent) {
		if (parent.equals("."))
			return;

		sb.append(parent);
		for (String child : G.get(parent))
			preorder(child);
	}

	public static void postorder(String parent) {
		if (parent.equals("."))
			return;

		for (String child : G.get(parent)) {
			postorder(child);
		}
		sb.append(parent);

	}

	public static void inorder(String parent) {
		if (parent == null || parent.equals("."))
			return;
		inorder(G.get(parent).get(0));
		sb.append(parent);
		inorder(G.get(parent).get(1));
	}

}
