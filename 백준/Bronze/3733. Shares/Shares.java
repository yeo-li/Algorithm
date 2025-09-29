import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue; // 공백 줄 무시
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                int N = Integer.parseInt(st.nextToken());
                if (!st.hasMoreTokens()) {
                    // 다음 줄에서 이어서 읽기
                    String next = br.readLine();
                    if (next == null) return;
                    st = new StringTokenizer(next);
                }
                long S = Long.parseLong(st.nextToken());
                System.out.println(S / (N + 1));
            }
        }
    }
}