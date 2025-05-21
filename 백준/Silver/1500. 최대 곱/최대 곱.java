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
		for (int i = 0; i < K; i++)
			arr[i] = 0;

		for (int i = 0; i < S; i++)
			arr[i % K] += 1;

		long rst = 1;
		for (int i = 0; i < K; i++)
			rst *= arr[i];

		System.out.println(rst);
	}

}