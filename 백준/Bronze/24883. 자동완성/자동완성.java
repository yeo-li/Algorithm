import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		if (input.equals("N") || input.equals("n"))
			System.out.println("Naver D2");
		else
			System.out.println("Naver Whale");
	}

}