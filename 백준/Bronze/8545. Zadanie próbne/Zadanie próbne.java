import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		for(int i = input.length - 1; i >= 0; i--) {
			System.out.print(input[i]);
		}
	}

}
