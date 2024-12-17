import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		System.out.println(A+B-C);
		int AB = Integer.parseInt(String.valueOf(A) + String.valueOf(B));
		System.out.println(AB-C);
		br.close();
	}
	
}
