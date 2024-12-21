import java.util.*;
import java.io.*;

public class Main {
    static long R;
    static long C;
    static long cnt;

    public static void main(String[] args) throws Exception {
        cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        R = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        long size = 1L << N; // 2^N 크기
        findZ(0, 0, size);
    }

    private static void findZ(long r, long c, long size) {
        if (size == 1) {
            System.out.println(cnt);
            return;
        }

        long half = size / 2;
        long area = half * half;

        // 사분면 확인
        if (R < r + half && C < c + half) {
            // 1사분면
            findZ(r, c, half);
        } else if (R < r + half && C >= c + half) {
            // 2사분면
            cnt += area;
            findZ(r, c + half, half);
        } else if (R >= r + half && C < c + half) {
            // 3사분면
            cnt += 2 * area;
            findZ(r + half, c, half);
        } else {
            // 4사분면
            cnt += 3 * area;
            findZ(r + half, c + half, half);
        }
    }
}
