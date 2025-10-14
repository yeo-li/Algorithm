import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n12 = sc.nextInt();

        // Chapman estimator formula
        double estimate = ((n1 + 1.0) * (n2 + 1.0)) / (n12 + 1.0) - 1.0;
        int N = (int) Math.floor(estimate);

        System.out.println(N);
    }
}