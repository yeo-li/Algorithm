import java.util.*;
import java.io.*;

public class Main {
	static boolean[] isSelfNumber = new boolean[10_001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10_001; i++)
			d(i);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10_001; i++) {
			if(!isSelfNumber[i])
				sb.append(i).append("\n");
		}
		
		System.out.println(sb);

	}

	public static void d(int n) {
		if (n > 10_000) {
			return;
		}

		int next = n;
		while (n != 0) {
			next += n % 10;
			n /= 10;
		}
		
		if(next > 10_000) return;
		
		isSelfNumber[next] = true;
		d(next);
	}

}
