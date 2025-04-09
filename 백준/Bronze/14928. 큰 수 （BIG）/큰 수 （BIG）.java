import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		long remainder = 0;
		for(int i = 0; i < input.length; i++)
			remainder = (remainder*10 + (input[i] - '0')) % 20000303;
		
		System.out.println(remainder);
	}

}