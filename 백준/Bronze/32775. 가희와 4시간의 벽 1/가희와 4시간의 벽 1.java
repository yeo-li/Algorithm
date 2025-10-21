import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S_ab = sc.nextInt(); // 고속철도 소요 시간
        int F_ab = sc.nextInt(); // 항공편 소요 시간

        if (S_ab <= F_ab) {
            System.out.println("high speed rail");
        } else {
            System.out.println("flight");
        }

        sc.close();
    }
}