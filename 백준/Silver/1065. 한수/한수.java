import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 1; i <= N; i++)
			if (isHansu(i))
				cnt++;

		System.out.print(cnt);

	}

	public static boolean isHansu(int N) {

		int a = N % 10;
		N /= 10;

		int d = a - N % 10;
		a = N % 10;
		N /= 10;
		while (N != 0) {
			if (a - N % 10 != d)
				return false;
			a = N % 10;
			N /= 10;

		}

		return true;
	}

}
