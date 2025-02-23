import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] Tree;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		Tree = new List[N];
		// dp = new int[N];
		for (int i = 0; i < N; i++)
			Tree[i] = new ArrayList<>();

		// tree sync
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			if (node == -1)
				continue;
			Tree[node].add(i);
		}

		int rst = postorder(0, 0);

		System.out.println(rst);

	}

	public static int postorder(int node, int depth) {
		List<Integer> list = new ArrayList<>();
		int[] dp = new int[N];
		int max = 0;
		// 자식들 중 가장 오래걸리는 녀석들 고르기
		for (int v : Tree[node]) {
			int rst = postorder(v, depth + 1);
			if (dp[rst] == 1) {
				int num = rst + 1;
				while (dp[num] != 0) {
					num++;
				}
				dp[num] = 1;
			} else
				dp[rst] = 1;
		}

		if (Tree[node].isEmpty())
			return depth;

		for (int i = N - 1; i >= 0; i--) {
			if (dp[i] != 0) {
				max = i;
				break;
			}
		}

		return max;
	}

}