import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력받은 연도
        System.out.println(N - 1946); // 개교 주년 계산
    }
}