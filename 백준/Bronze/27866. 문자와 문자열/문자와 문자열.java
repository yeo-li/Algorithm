import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(input.charAt(N-1));
		
		br.close();
	}
	
}
