import java.io.*;
public class Main {
	static int[] parent, rank;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, i, j, fc;
	public static void main(String[] args) throws Exception {
		N = read(); M = read();
		parent = new int[N + 1]; rank = new int[N + 1];
		for (i = 1; i <= N; i++) {
			parent[i] = i; rank[i] = 1;
		}
		for (i = 1; i <= N; i++) {
			for (j = 1; j <= N; j++) {
				if (read() == 1) union(i, j);
			}
		}
		fc = find(read());
		for (i = 1; i < M; i++) {
			if (find(read()) != fc) {
				bw.write("NO");bw.flush();bw.close();return;
			}
		}
		bw.write("YES");bw.flush();bw.close();
	}
	public static void union(int x, int y) {
		int rootX = find(x);int rootY = find(y);
		if (rootX != rootY) {
			if (rank[rootX] > rank[rootY]) {parent[rootY] = rootX;
			} else if (rank[rootX] < rank[rootY]) {parent[rootX] = rootY;
			} else {parent[rootY] = rootX;rank[rootX]++;
			}
		}
	}
	public static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}