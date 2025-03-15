import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());
		BigInteger M = new BigInteger(br.readLine());
		
		BigInteger HN = N.divide(new BigInteger("2"));
		BigInteger HM = M.divide(new BigInteger("2"));
		
		if(N.add(M).compareTo(new BigInteger("1")) == 0) {
			System.out.println(N.add(M).subtract(new BigInteger("1")).divide(new BigInteger("2"))
					+ "\n" + 
					N.subtract(N.add(M).subtract(new BigInteger("1")).divide(new BigInteger("2"))));
		} else {
			System.out.println(N.add(M).divide(new BigInteger("2")) + 
			"\n" + N.subtract(N.add(M).divide(new BigInteger("2")))
		);
		}
	}

}