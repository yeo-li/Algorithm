import java.util.*;
import java.io.*;

public class Main {
	static Map<Integer, List<Integer>> G = new HashMap<>();
	static Set<Integer> truthClub = new HashSet<>();
	static List<Integer> list = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 그래프 초기화
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			G.put(i, new ArrayList<>());

		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());

		while (cnt-- > 0) {
			truthClub.add(Integer.parseInt(st.nextToken()));
		}

		// 파티 참여 인원 입력
		List<int[]> party = new ArrayList<>();
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			int[] arr = new int[cnt];
			for (int i = 0; i < cnt; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			party.add(arr);
		}

		// 함께한 인원들을 그래프로 연결한다.
		for (int[] p : party) {
			for (int i = 0; i < p.length - 1; i++) {
				// 여기서 그래프 추가하기
				G.get(p[i]).add(p[i + 1]);
				G.get(p[i + 1]).add(p[i]);
			}
		}

		for (int t : truthClub) {
			dfs(t);
		}

		for (int v : list) {
			truthClub.add(v);
		}

		int rst = 0;
		for (int[] p : party) {
			for (int i = 0; i < p.length; i++) {
				if (truthClub.contains(p[i])) {
					rst--;
					break;
				}
			}
			rst++;
		}

		System.out.println(rst);

	}

	public static void dfs(int start) {
		visited[start] = true;
		for (int v : G.get(start)) {
			if (!visited[v]) {
				list.add(v);
				dfs(v);
			}
		}
	}

}
