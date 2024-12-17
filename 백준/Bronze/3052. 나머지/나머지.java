import java.util.*;
import java.io.*;

public class Main {

	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		while(true) {
			input = br.readLine();
			if(input == null) break;
			
			set.add(Integer.parseInt(input)%42);
		}
		
		System.out.println(set.size());
		
		br.close();
	}
	
}
