import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String heart = " @@@   @@@ \n"
				+ "@   @ @   @\n"
				+ "@    @    @\n"
				+ "@         @\n"
				+ " @       @ \n"
				+ "  @     @  \n"
				+ "   @   @   \n"
				+ "    @ @    \n"
				+ "     @     ";
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++)
			System.out.println(heart);
		
		
	}

}
