import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String c= sc.next();
		String c2 = sc.next();

		int result = solution(Integer.parseInt(c), Integer.parseInt(c2));
		
		System.out.println(result);
	}
	
	private static int solution(int N, int K) {
		int asnwer = 0;
		
		int[][] arr = new int[N+1][N+1];
		
		arr[1][0] = 1;
		for(int i = 2; i < N+1; i++) {
			for(int j = 0; j < i+1; j++) {
				if(j == 0) {
					arr[i][j] = 1;	
					continue;
				}
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		
		asnwer = arr[N][K-1];
		
		return asnwer;
	}
	
}
