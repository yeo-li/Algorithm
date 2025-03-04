import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // Union-Find로 도시 연결
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) union(i, j);
            }
        }

        // 여행 계획 검증
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstCity = find(Integer.parseInt(st.nextToken())); // 첫 번째 도시의 루트
        for (int i = 1; i < M; i++) {
            if (find(Integer.parseInt(st.nextToken())) != firstCity) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) parent[rootY] = rootX;
    }

    public static int find(int x) {
        return parent[x] = (parent[x] == x) ? x : find(parent[x]);
    }
}