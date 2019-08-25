package code;

import java.util.Scanner;


public class 分解整数 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sin = new Scanner(System.in);
        int num = sin.nextInt();
        for (int i = 0; i < num; ++i) {
            System.out.println(check(sin.nextLong()));
        }
    }

    public static String check(long s) {
        if (s % 2 == 1) {
            return "No";
        }
        double max = Math.sqrt(s);
        for (int i = 2; i < s; i += 2) {
            if (s % i == 0 && (s / i) % 2 == 1) {
                return (s / i) + " " + i;
            }
        }
        return "No";
    }


}