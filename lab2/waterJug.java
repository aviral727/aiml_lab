import java.io.*;

class waterJug {

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public static int pour(int fromCap, int toCap,
            int d) {

        int from = fromCap;
        int to = 0;

        int step = 1;

        while (from != d && to != d) {

            int temp = Math.min(from, toCap - to);

            to += temp;
            from -= temp;

            step++;

            if (from == d || to == d)
                break;

            if (from == 0) {
                from = fromCap;
                step++;
            }

            if (to == toCap) {
                to = 0;
                step++;
            }
        }
        return step;
    }

    public static int minSteps(int m, int n, int d) {

        if (m > n) {
            int t = m;
            m = n;
            n = t;
        }

        if (d > n)
            return -1;

        if ((d % gcd(n, m)) != 0)
            return -1;

        return Math.min(pour(n, m, d),
                pour(m, n, d));
    }

    public static void main(String[] args) {

        System.out.println("enter value of jug1, jug2 and required water respectively");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        System.out.println("Minimum number of " +
                "steps required is " +
                minSteps(m, n, d));
    }
}