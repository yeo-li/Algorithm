import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] board;
	static int turnCnt, turnLen; // 초기는 1
	static int directionCnt, direction, move; // 초기는 left
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int y = N / 2;
		int x = N / 2;
		turnLen = 1;
		turnCnt = 0;
		direction = 0;
		move = 0;
		int cnt = 1;
		int totalSand = 0;
		while (true) {
			// 여기서 계산할 수 있음
			// y 좌표 계산
			int yDirection = expectDirection();
			int yy = y + dy[yDirection];
			int yx = x + dx[yDirection];

			if(yy < 0 || yx < 0) break;
			
			// 필터값 계산
			int[][] filter = calculateFilter(yy, yx, yDirection);
			
			// 필터값 board에 적용
			totalSand += addFilter(yy, yx, filter);
		
			// 좌표 x -> y로 이동함
			calculateDirection(); // 방향을 바꿈
			// 좌표를 바꿈
			y = y + dy[direction];
			x = x + dx[direction];
		}
		
		System.out.println(totalSand);
	}

	public static void calculateDirection() {
		if (turnLen > move) {
			move++;
			return;
		}

		if (turnCnt == 1) {
			turnLen++;
			turnCnt = 0;
		} else {
			turnCnt++;
		}

		move = 1;
		direction++;
		direction %= 4;
	}
	
	public static int expectDirection() {
		if (turnLen > move) {
			return direction;
		}

		return (direction + 1) % 4;
	}

	public static int[][] calculateFilter(int yy, int yx, int nextDirection) {
		int[][][] filter = {
				{
					{0, 0, 2, 0, 0},
					{0, 10, 7, 1, 0},
					{5, 0, 0, 0, 0},
					{0, 10, 7, 1, 0},
					{0, 0, 2, 0, 0}
				},
				{
					{0, 0, 0, 0, 0},
					{0, 1, 0, 1, 0},
					{2, 7, 0, 7, 2},
					{0, 10, 0, 10, 0},
					{0, 0, 5, 0, 0}
				},
				{
					{0, 0, 2, 0, 0},
					{0, 1, 7, 10, 0},
					{0, 0, 0, 0, 5},
					{0, 1, 7, 10, 0},
					{0, 0, 2, 0, 0}
				},
				{
					{0, 0, 5, 0, 0},
					{0, 10, 0, 10, 0},
					{2, 7, 0, 7, 2},
					{0, 1, 0, 1, 0},
					{0, 0, 0, 0, 0}
				}
		};
		
		int totalSand = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				filter[nextDirection][i][j] = (int) (filter[nextDirection][i][j]/100.0*board[yy][yx]);
				totalSand += filter[nextDirection][i][j];
				
			}
		}
		
		// a 계산
		filter[nextDirection][2+dy[nextDirection]][2+dx[nextDirection]] = board[yy][yx] - totalSand;
		
		return filter[nextDirection];
	}
	
	public static int addFilter(int y, int x, int[][] filter) {
		int overSand = 0;
		for(int i = y - 2; i < y + 3; i++) {
			for(int j = x - 2; j < x + 3; j++) {
				if(isPossable(i, j)) {
					board[i][j] += filter[i - y + 2][j - x + 2];
				} else {
					overSand += filter[i - y + 2][j - x + 2];
				}
			}
		}
		
		return overSand;
	}
	
	public static boolean isPossable(int y, int x) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

}