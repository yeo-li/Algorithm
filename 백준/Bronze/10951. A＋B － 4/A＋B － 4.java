import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		while(true) {
			input = br.readLine();
			if(input == null) break;
			StringTokenizer st = new StringTokenizer(input);
			System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
		}
		
		br.close();
	}
	
}
