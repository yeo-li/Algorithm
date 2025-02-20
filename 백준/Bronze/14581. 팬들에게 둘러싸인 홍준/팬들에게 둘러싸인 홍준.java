import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = ":" + br.readLine() + ":";
		String fan = ":fan:";
		StringBuilder sb = new StringBuilder();
		sb.append(fan).append(fan).append(fan).append("\n");
		sb.append(fan).append(name).append(fan).append("\n");
		sb.append(fan).append(fan).append(fan);
		
		System.out.println(sb);
	}

}