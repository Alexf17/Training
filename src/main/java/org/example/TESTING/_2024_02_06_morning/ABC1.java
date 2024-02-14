package org.example.TESTING._2024_02_06_morning;

public class ABC1 {
    public int sum (int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if( b==0){
            throw new ArithmeticException();
        }
        return a/b;
    }
}
