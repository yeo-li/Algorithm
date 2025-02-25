import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 크레인의 수
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] crane = new Integer[N];
		for (int i = 0; i < N; i++)
			crane[i] = Integer.parseInt(st.nextToken());

		// 박스의 수
		int M = Integer.parseInt(br.readLine());
		Integer[] box = new Integer[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			box[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(crane, (o1, o2) -> (o2 - o1));
		Arrays.sort(box, (o1, o2) -> o2 - o1);

		if (crane[0] < box[0]) {
			System.out.println(-1);
			return;
		}

		int[] craneBox = new int[N];
		for (int i = 0; i < M; i++) {
			int start = -1;
			int end = N;
			for (int j = 0; j < N; j++) {
				if (start < 0 && crane[j] >= box[i])
					start = j;
				if (end == N && crane[j] < box[i]) {
					end = j;
					break;
				}
			}

			// find min index
			int minIdx = start;
			int min = craneBox[start];
			for (int j = start; j < end; j++) {
				if (min > craneBox[j]) {
					min = craneBox[j];
					minIdx = j;
				}
			}

			craneBox[minIdx]++;
		}

		int rst = 0;
		while (true) {
			boolean isAllZero = true;
			for (int i = 0; i < N; i++) {
				if (craneBox[i] != 0) {
					isAllZero = false;
					craneBox[i]--;
				}
			}
			if (isAllZero) {
				break;
			} else {
				rst++;
			}
		}

		System.out.println(rst);
	}
}