package org.example.TESTING._2024_02_06_morning;

public class Taski {
    //    Сложение (add): Принимает два числа и возвращает их сумму.
    public  int add(int a, int b) {
        return a + b;
    }

    //    Вычитание (subtract): Принимает два числа и возвращает результат их вычитания.
    public  int subtract(int a, int b) {
        return a - b;
    }

    //    Умножение (multiply): Принимает два числа и возвращает их произведение.
    public  int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return a * b;
    }

    //    Деление (divide): Принимает два числа и возвращает результат деления первого на второе. Необходимо обработать случай деления на ноль.
    public  int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    //    Возведение в степень (power): Принимает основание и показатель степени, возвращает результат возведения числа в степень.
    public  double power(double base, double power) {
        if (power == 0) {
            return 1;
        }
        double result = 1;
        for (int i = 0; i < power; i++) {
            result = result * base;
        }
        return result;
    }

    //    Факториал (factorial): Принимает число и возвращает его факториал. Должна быть обработка отрицательных чисел.
    public  int factorial(int num) {
        if (num < 0) {
            throw new ArithmeticException();
        }
        if (num == 0 || num == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;

    }

    //    Модуль числа (absolute): Принимает число и возвращает его абсолютное значение.
    public  double absolute(double num) {
        if (num < 0) {
            return -num;
        } else {
            return num;
        }
    }

    //    Квадратный корень (sqrt): Принимает число и возвращает квадратный корень числа. Необходимо учесть обработку отрицательных чисел.
    public  double sqrt(int num) {
        double epsilon = 1e-15;
        double x = num;
        while (absolute(x - num / x) > epsilon * x) {
            x = (x + num / x) / 2;
        }
        return x;
    }

    //    Логарифм (logarithm): Принимает основание логарифма и число, для которого необходимо вычислить логарифм.
    public  double logarithm(int base, int num) {
        if (base <= 0) throw new ArithmeticException();
        if (base == 1) return 0;
        double result = 0;
        while (num >= base) {
            num /= base;
            result++;
        }
        double fraction = num - 1;
        double power = 1;
        double term = fraction;
        int sign = 1;
        while (absolute(term) > 1e-10) {
            power *= fraction;
            term = sign * power / ++result;
            sign = -sign;
            result += term;
        }
        return result;
    }

    //    Синус (sin): Принимает угол в радианах и возвращает его синус.
    public  double sin(double corner) {
        int n = 10;
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result += power(-1, i) * power(corner, 2 * i + 1) / factorial(2 * i + 1);
        }
        return result;
    }
}
