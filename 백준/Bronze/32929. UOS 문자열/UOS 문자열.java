import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int tmp = N%3;
		if(tmp == 1)
			System.out.println("U");
		else if(tmp == 2)
			System.out.println("O");
		else
			System.out.println("S");
	}

}