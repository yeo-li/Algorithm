import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(br.readLine().trim());

        int total = A * 3600 + B * 60 + C;        // 현재 시각(초)
        total += D;                                // 조리 시간 더하기
        total %= 86400;                            // 하루(24*3600)로 순환

        int hh = total / 3600;
        int mm = (total % 3600) / 60;
        int ss = total % 60;

        System.out.println(hh + " " + mm + " " + ss);
    }
}