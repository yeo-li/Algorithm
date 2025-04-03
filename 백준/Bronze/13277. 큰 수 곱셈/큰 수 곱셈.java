import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[] eyes = new int[6];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		BigInteger N = new BigInteger(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < 6; i++)
//			eyes[i] = Integer.parseInt(st.nextToken());
//
//		BigInteger a = new BigInteger("8").multiply(N).subtract(new BigInteger(Integer.toString(12)));
//		BigInteger b = N.subtract(new BigInteger("2"));
//		BigInteger c = N.subtract(new BigInteger("2")).multiply(b);
//		
//		BigInteger three = new BigInteger(Long.toString(getThreeMin())).multiply(new BigInteger("4"));
//		BigInteger two = new BigInteger(Long.toString(getThreeMin())).multiply(a);
//		BigInteger one = new BigInteger(Long.toString(getThreeMin())).multiply(c.multiply(new BigInteger("5")).add(b.multiply(new BigInteger("4"))));
//
//		
//		
//		
//		System.out.println(three.add(two).add(one));

		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		System.out.println(a.multiply(b));
		
	}

	public static long getThreeMin() {
		int min = Integer.MAX_VALUE;
		// EDA - 034
		min = Math.min(min, eyes[0] + eyes[3] + eyes[4]);
		// ABC - 012
		min = Math.min(min, eyes[0] + eyes[1] + eyes[2]);
		// EAC - 024
		min = Math.min(min, eyes[0] + eyes[2] + eyes[4]);
		// DAB - 013
		min = Math.min(min, eyes[0] + eyes[1] + eyes[3]);
		// CBF - 125
		min = Math.min(min, eyes[1] + eyes[2] + eyes[5]);
		// DBF - 134
		min = Math.min(min, eyes[1] + eyes[3] + eyes[4]);
		// FCE - 245
		min = Math.min(min, eyes[2] + eyes[4] + eyes[5]);
		// FDE - 345
		min = Math.min(min, eyes[3] + eyes[4] + eyes[5]);

		return min;
	}

	public static long getTwoMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 4; i++)
			min = Math.min(min, eyes[0] + eyes[i]);
		for (int i = 2; i <= 5; i++) {
			if (i == 4)
				continue;
			min = Math.min(min, eyes[1] + eyes[i]);
		}
		for (int i = 4; i <= 5; i++)
			min = Math.min(min, eyes[2] + eyes[i]);
		for (int i = 4; i <= 5; i++)
			min = Math.min(min, eyes[3] + eyes[i]);
		min = Math.min(min, eyes[4] + eyes[5]);

		return min;
	}

	public static long getOneMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++)
			min = Math.min(min, eyes[i]);
		return min;
	}

}