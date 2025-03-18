import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int rst = N/5;
		if(N%5 != 0) 
			rst++;
		System.out.println(rst);

	}
}