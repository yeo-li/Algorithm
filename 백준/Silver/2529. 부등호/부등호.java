import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[] mins, maxs;
	static String[] sign;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		sign = new String[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			sign[i] = st.nextToken();

		mins = "0123456789".toCharArray(); // <
		maxs = "9876543210".toCharArray(); // >

		solve("<", mins);
		solve(">", maxs);

		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= N; i++)
			sb.append(maxs[i]);
		sb.append("\n");
		for (int i = 0; i <= N; i++)
			sb.append(mins[i]);

		System.out.println(sb);
	}

	public static void solve(String s, char[] arr) {
		for (int i = 1; i <= N; i++) {
			if (sign[i].equals(s))
				continue;
			int end = i;
			for (int j = i; j <= N; j++) {
				if (sign[j].equals(s))
					break;
				end = j;
			}

			int length = (end - i + 1) / 2;

			for (int j = i - 1; j <= i - 1 + length; j++) {
				char tmp = arr[j];
				arr[j] = arr[end - (j - i + 1)];
				arr[end - (j - i + 1)] = tmp;
			}

			i = end;
		}
	}

}
