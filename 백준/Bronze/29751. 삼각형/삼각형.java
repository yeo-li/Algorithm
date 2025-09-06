import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double rst = Double.parseDouble(st.nextToken())*Double.parseDouble(st.nextToken())/2.0;
		
		System.out.printf("%.1f", rst);
		
		
	}

}
