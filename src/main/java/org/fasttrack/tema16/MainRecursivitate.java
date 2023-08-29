package org.fasttrack.tema16;

public class MainRecursivitate {

    public static void main(String[] args) {
        System.out.println(sumOfEven(10));
        System.out.println(sumOfDigits(123456789));
        System.out.println(fibonacci(6));
    }

    //10: 10 * 2 + 9 * 2 + 8 * 2
    public static int sumOfEven(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n * 2 + sumOfEven(n - 1);
        }
    }

    //12345678 9
    public static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        }
//        if (n == 0) {
//            return 0;
//        }
        //n % 10 -> n / 10
        return n % 10 + sumOfDigits(n / 10);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
