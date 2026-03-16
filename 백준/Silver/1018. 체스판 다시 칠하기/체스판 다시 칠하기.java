import java.util.*;
import java.io.*;

public class Main {
	static char[][] board;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			board[i] = input; // 꿀팁
		}

		int cnt = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				cnt = Math.min(cnt, chess(i, j, i + 8, j + 8, 'W', 'B'));
				cnt = Math.min(cnt, chess(i, j, i + 8, j + 8, 'B', 'W'));
			}
		}

		System.out.println(cnt);
	}

	public static int chess(int startY, int startX, int endY, int endX, char c1, char c2) {
		int cnt = 0;
		for (int i = startY; i < endY; i++) {
			char c = c1;
			if (i % 2 != 0)
				c = c2;

			for (int j = startX; j < endX; j++) {
				if (board[i][j] != c)
					cnt++;
				c = c1 == c ? c2 : c1;
			}
		}

		return cnt;
	}

}
