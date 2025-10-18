import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String S = br.readLine().trim();

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case 'a':
                case 'i':
                case 'u':
                case 'e':
                case 'o':
                    count++;
                    break;
                default:
            }
        }

        System.out.println(count);
    }
}