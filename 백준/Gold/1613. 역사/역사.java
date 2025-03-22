import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] G;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        G = new boolean[N + 1][N + 1];

        // 초기 입력 값 저장
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            G[A][B] = true;
        }

        // ✅ 플로이드-워셜 알고리즘 (경유지 k → 출발지 i → 도착지 j 순서)
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (G[i][k] && G[k][j]) {
                        G[i][j] = true;
                    }
                }
            }
        }

        // ✅ 쿼리 처리
        StringBuilder sb = new StringBuilder();
        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (G[A][B]) sb.append("-1\n");  // A가 B보다 앞섬
            else if (G[B][A]) sb.append("1\n"); // B가 A보다 앞섬
            else sb.append("0\n"); // 관계 없음
        }

        System.out.println(sb);
    }
}