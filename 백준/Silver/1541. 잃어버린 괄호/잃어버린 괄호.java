import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		String[] input = tmp.split("-");
		int rst = 0;
		boolean sen = true;
		for(String str : input) {
			int sum = 0;
			if(str.contains("+")) {
				String[] numbers = str.split("\\+");	
				for(String n : numbers)
					sum += Integer.parseInt(n);
				
			} else {
				sum = Integer.parseInt(str);
			}
			
			if(sen) {
				rst += sum;
				sen = false;
			} else rst -= sum;
		}
		
		if(input.length == 1 && tmp.charAt(0) == '-') rst *= -1;
		
		System.out.println(rst);
	}
}