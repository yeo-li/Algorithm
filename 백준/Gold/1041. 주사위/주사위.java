import java.util.*;
import java.io.*;

public class Main {
	static long CORE, EDGE, CORNER;
	static int[] dice;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Integer.parseInt(br.readLine());

		dice = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		if (N == 1) {
			System.out.println(findMinValue());
			return;
		}

		CORE = (N - 2) * (N - 2) * 5 + (N - 2) * 4;
		EDGE = (N - 2) * 8 + 4;
		CORNER = 4;

		long result = CORE * findCore() + EDGE * findEdge() + CORNER * findCorner();

		long tmp = findCorner();

		System.out.println(result);
	}

	public static int findMinValue() {
		int max = 0;
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += dice[i];
			if (max < dice[i])
				max = dice[i];
		}

		return sum - max;
	}

	public static long findCore() {
		long min = Long.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			if (min > dice[i])
				min = dice[i];
		}
		return min;
	}

	public static long findEdge() {
		int[][] edgeList = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 1, 5 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 2, 5 },
				{ 3, 4 }, { 3, 5 }, { 4, 5 } };

		long min = Long.MAX_VALUE;
		for (int[] edge : edgeList) {
			if (min > dice[edge[0]] + dice[edge[1]])
				min = dice[edge[0]] + dice[edge[1]];
		}

		return min;
	}

	public static long findCorner() {
		int[][] cornerList = { { 0, 1, 2 }, { 0, 1, 3 }, { 0, 2, 4 }, { 0, 3, 4 }, { 1, 3, 5 }, { 3, 4, 5 },
				{ 1, 2, 5 }, { 2, 4, 5 } };

		long min = Long.MAX_VALUE;
		for (int[] corner : cornerList) {
			if (min > dice[corner[0]] + dice[corner[1]] + dice[corner[2]])
				min = dice[corner[0]] + dice[corner[1]] + dice[corner[2]];
		}

		return min;
	}

}
