import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] nameY = br.readLine().toCharArray();
		int N = Integer.parseInt(br.readLine());

		int l = 0, o = 0, v = 0, e = 0;
		for (char c : nameY) {
			if (c == 'L')
				l++;
			else if (c == 'O')
				o++;
			else if (c == 'V')
				v++;
			else if (c == 'E')
				e++;
		}

		int max = Integer.MIN_VALUE;
		String bestName = "";

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			int L = l, O = o, V = v, E = e;
			for (char c : name.toCharArray()) {
				if (c == 'L')
					L++;
				else if (c == 'O')
					O++;
				else if (c == 'V')
					V++;
				else if (c == 'E')
					E++;
			}

			int rst = win(L, O, V, E);
			if (rst > max) {
				max = rst;
				bestName = name;
			} else if (rst == max) {
				bestName = bestName.compareTo(name) > 0 ? name : bestName;
			}
		}

		System.out.println(bestName);
	}

	public static int win(int L, int O, int V, int E) {
		return ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
	}

}