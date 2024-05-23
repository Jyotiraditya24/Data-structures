package RecursionBacktracking;

import java.util.Scanner;

public class PowerLog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        double x = sc.nextDouble();
        System.out.println("Enter the power");
        int n = sc.nextInt();
        double xn = power(x, n);
        System.out.println(xn);
    }

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double p = power(x, n / 2);
        double ans = p * p;
        if (n % 2 != 0) {
            ans = ans * x;
        }
        return ans;
    }
}
