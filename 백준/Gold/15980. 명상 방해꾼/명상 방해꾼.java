import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] contrib = new int[N + 1][M + 1]; // 각 새의 j초 기여값
        int[] total = new int[M + 1];            // 모든 새의 합

        // 입력 처리
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int sign = dir.equals("L") ? -1 : 1; // 왼쪽이면 -1, 오른쪽이면 +1
            char[] sounds = st.nextToken().toCharArray();

            for (int j = 1; j <= M; j++) {
                if (sounds[j - 1] == '1') {
                    contrib[i][j] = sign;
                    total[j] += sign;
                }
            }
        }

        // 모든 새가 있을 때의 누적 정신 중심 (prefix sum)
        int[] mental = new int[M + 1];
        for (int j = 1; j <= M; j++) {
            mental[j] = mental[j - 1] + total[j];
        }

        int bestBird = N + 1;
        int bestValue = Integer.MAX_VALUE;

        // 한 마리씩 제거
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            int curMax = 0;
            for (int j = 1; j <= M; j++) {
                // mental[j] - contrib[i][j] == i번 새를 뺀 j초 정신 중심 변화량
                sum += total[j] - contrib[i][j];
                curMax = Math.max(curMax, Math.abs(sum));
            }
            if (curMax < bestValue || (curMax == bestValue && i < bestBird)) {
                bestBird = i;
                bestValue = curMax;
            }
        }

        // 출력: 새 번호 → 방해 정도
        System.out.println(bestBird);
        System.out.println(bestValue);
    }
}