import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			board[i] = input;
		}

		int rst = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++)
				rst = Math.min(rst, solution(i, j));
		}

		System.out.println(rst);
	}

	public static int solution(int y, int x) {
		int cntBlack = 0;
		boolean isBlackN = true;
		for (int i = y; i < y + 8; i++) {
			boolean isBlackM = isBlackN;
			for (int j = x; j < x + 8; j++) {
				if (isBlackM && board[i][j] == 'W') {
					cntBlack++;
				} else if (!isBlackM && board[i][j] == 'B') {
					cntBlack++;
				}
				isBlackM = !isBlackM;
			}
			isBlackN = !isBlackN;
		}

		int cntWithe = 0;
		boolean isWitheN = true;
		for (int i = y; i < y + 8; i++) {
			boolean isWitheM = isWitheN;
			for (int j = x; j < x + 8; j++) {
				if (isWitheM && board[i][j] == 'B') {
					cntWithe++;
				} else if (!isWitheM && board[i][j] == 'W') {
					cntWithe++;
				}
				isWitheM = !isWitheM;
			}
			isWitheN = !isWitheN;
		}

		return Math.min(cntBlack, cntWithe);
	}
}
