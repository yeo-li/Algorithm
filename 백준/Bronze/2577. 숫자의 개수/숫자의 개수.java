import java.util.*;
import java.io.*;

public class Main {

	static TreeMap<Integer, Integer> frequency = new TreeMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 10; i++) {
			frequency.put(i, frequency.getOrDefault(i, 0));
		}
		
		long result = Long.parseLong(br.readLine())
				*Long.parseLong(br.readLine())
				*Long.parseLong(br.readLine());
		
		char[] arr = String.valueOf(result).toCharArray();
		for(char a: arr) {
			frequency.put(Integer.parseInt(String.valueOf(a)), 
					frequency.getOrDefault(Integer.parseInt(String.valueOf(a)), 0) + 1);
		}
		
		for(int key: frequency.keySet()) {
			System.out.println(frequency.get(key));
		}
		
		br.close();
	}
	
}
