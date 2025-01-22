import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static boolean[][] board;
	static int[][] visited;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int[] ddy = { 1, -1, 1, -1 };
	static int[] ddx = { 1, 1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(620 <= n && n <= 780) System.out.println("Red");
		else if(590 <= n && n < 620) System.out.println("Orange");
		else if(570 <= n && n < 590) System.out.println("Yellow");
		else if(495 <= n && n < 570) System.out.println("Green");
		else if(450 <= n && n < 495) System.out.println("Blue");
		else if(425 <= n && n < 450) System.out.println("Indigo");
		else if(380 <= n && n < 425) System.out.println("Violet");
	}

}
