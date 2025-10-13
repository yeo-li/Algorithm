import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); // 트리의 전류 (ampere)
        int w = sc.nextInt(); // 어댑터의 전력 (watt)
        int v = sc.nextInt(); // 어댑터의 전압 (volt)

        int adapterAmp = w / v; // 어댑터 전류 계산

        if (adapterAmp >= a)
            System.out.println(1);
        else
            System.out.println(0);
    }
}