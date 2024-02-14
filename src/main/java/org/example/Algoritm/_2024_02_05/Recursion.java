package org.example.Algoritm._2024_02_05;
public class Recursion {
    public static void main(String[] args) {
//        System.out.println(S(6));
//        System.out.println(SWithFor(5));
//        System.out.println(fibonacci(9));
//        System.out.println(fibonacciWithFor(9));
        int[] arr = {1, 6, 12, 45, 78, 84, 97, 123, 145, 187};
        System.out.println(binarySearch(arr, 46));
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            throw new RuntimeException("Number must be positive");
        }
        if (n == 1 || n == 2) return n - 1;
//        if (n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciWithFor(int n) {
        if (n <= 0) {
            throw new RuntimeException("Number must be positive");
        }
        if (n == 1 || n == 2) return n - 1;
        int sum = 0;
        int a = 0;
        int b = 1;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static int S(int n) {
        if (n <= 0) {
            throw new RuntimeException("Number must be positive");
        }
        if (n == 1) return n;
        return S(n - 1) + n;
    }

    public static int SWithFor(int n) {
        int sum = 0;
        if (n <= 0) {
            throw new RuntimeException("Number must be positive");
        }
        if (n == 1) return n;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int binarySearch(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        while (end >= start) {
            int mid = (end + start) / 2;
            if (num > arr[mid]) {
                start = mid + 1;
            } else if (num < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
