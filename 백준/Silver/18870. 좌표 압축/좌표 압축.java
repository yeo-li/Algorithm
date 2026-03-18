import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));
		List<Integer> list2 = new ArrayList<>(new HashSet<>(list));
		Collections.sort(list2);

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list2.size(); i++)
			map.put(list2.get(i), i);

		StringBuilder sb = new StringBuilder();
		for (int n : list) {
			sb.append(map.get(n)).append(" ");
		}

		System.out.println(sb);

	}

}
