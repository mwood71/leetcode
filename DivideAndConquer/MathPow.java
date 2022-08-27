package Leetcode.DivideAndConquer;

public class MathPow {
    public static void main(String[] args) {
        MathPow m = new MathPow();
        System.out.println(m.myPow(2, -10));
    }
    public double myPow(double x, long n) {
       if (n == 1) return x;
       if (n == 0) return 1;

       if (n < 0) return 1 / myPow(x, -n);

       if (n % 2 == 1) return x * myPow(x, n - 1);
       return myPow(x * x, n / 2);
    }
}
// Input: x = 2.00000, n = 10
// Output: 1024.00000