import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String result = findLexicographicallySmallestWord(input);
        System.out.println(result);
    }

    private static String findLexicographicallySmallestWord(String word) {
        int length = word.length();
        String smallestWord = null;

        // 첫 번째 분할 지점 i, 두 번째 분할 지점 j를 선택
        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                // 세 부분으로 나누어 각각 뒤집기
                String part1 = new StringBuilder(word.substring(0, i)).reverse().toString();
                String part2 = new StringBuilder(word.substring(i, j)).reverse().toString();
                String part3 = new StringBuilder(word.substring(j)).reverse().toString();

                // 세 부분을 합쳐 새로운 단어 생성
                String combinedWord = part1 + part2 + part3;

                // 가장 작은 단어 갱신
                if (smallestWord == null || combinedWord.compareTo(smallestWord) < 0) {
                    smallestWord = combinedWord;
                }
            }
        }
        return smallestWord;
    }
}
