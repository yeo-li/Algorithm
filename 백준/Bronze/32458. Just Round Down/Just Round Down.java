import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();

        // '.' 기준으로 나누기
        int dotIndex = x.indexOf('.');
        if (dotIndex == -1) { 
            // 혹시 정수 형태로 들어오는 경우 (안 나올 수도 있지만)
            System.out.println(x);
        } else {
            System.out.println(x.substring(0, dotIndex));
        }
    }
}