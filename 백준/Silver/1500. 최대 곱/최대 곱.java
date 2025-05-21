import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[K];
		int a = S/K;
		for (int i = 0; i < K; i++)
			arr[i] = a;

		for (int i = 0; i < S%K; i++)
			arr[i] += 1;

		long rst = 1;
		for (int i = 0; i < K; i++)
			rst *= arr[i];

		System.out.println(rst);
	}

}