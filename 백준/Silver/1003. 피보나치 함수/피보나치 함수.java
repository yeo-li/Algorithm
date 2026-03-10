import java.util.*;
import java.io.*;

public class Main {
	static int[][] result = new int[41][2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result[0][0] = 1;
		result[0][1] = 0;
		result[1][0] = 0;
		result[1][1] = 1;

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] rst = fibonacci(N);
			sb.append(rst[0] + " " + rst[1]).append("\n");
		}

		System.out.println(sb);
	}

	public static int[] fibonacci(int n) {
		if (result[n][0] != 0 || result[n][1] != 0) {
			return result[n];
		}

		int[] result1 = fibonacci(n - 1);
		int[] result2 = fibonacci(n - 2);

		result[n][0] = result1[0] + result2[0];
		result[n][1] = result1[1] + result2[1];

		return result[n];
	}

}
