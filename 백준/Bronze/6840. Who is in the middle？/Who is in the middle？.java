import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		arr[0] = Integer.parseInt(br.readLine());
		arr[1] = Integer.parseInt(br.readLine());
		arr[2] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		System.out.println(arr[1]);
    }
}