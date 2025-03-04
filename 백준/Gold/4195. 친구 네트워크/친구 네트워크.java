import java.util.*;
import java.io.*;

public class Main {
	static Map<String, Integer> friend = new HashMap<>();
	static int[] fList, parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int F = Integer.parseInt(br.readLine());
			fList = new int[F * 2];
			parent = new int[F * 2];
			for (int i = 0; i < F * 2; i++) {
				parent[i] = i;
				fList[i] = 1;
			}

			int idx = 0;
			while (F-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if (!friend.keySet().contains(name1)) {
					friend.put(name1, idx);
					idx++;
				}
				if (!friend.keySet().contains(name2)) {
					friend.put(name2, idx);
					idx++;
				}

				int idx1 = friend.get(name1);
				int idx2 = friend.get(name2);

				union(idx1, idx2);
				int p = find(idx1);
				sb.append(fList[p]).append("\n");
			}

		}

		System.out.println(sb);
	}

	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			parent[rootY] = rootX;
			fList[rootX] += fList[rootY];
		}
	}

	public static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

}