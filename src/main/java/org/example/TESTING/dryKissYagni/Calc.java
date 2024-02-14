package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Нарушение CODE SMELLS: Магические числа
class Calc {
    public double calculateArea(int shapeType, double... params) {
        if (shapeType == 1) { // 1- круг

        } else if (shapeType == 2) { // 2 - квадрат
            double side = params[0];
            return side * side;
        } else if (shapeType == 3) { // 3 - треугольник
            double a = params[0];
            double b = params[1];
            double c = params[2];
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
        return 0.0;
    }

}


class CalcI {
    public static void main(String[] args) {
        double[] params = {2, 5, 5};

        System.out.println(calculateArea(2, params));
    }

    public static double calculateArea(int shapeType, double... params) {
        if ((shapeType != 1 && shapeType != 2 && shapeType != 3) || params.length == 0) {
            throw new IllegalArgumentException("Invalid argument");
        }
        for (double param : params) {
            if (param <= 0) {
                throw new ArithmeticException("Arguments must be greater than zero");
            }
        }
        if (shapeType == 1) {
            return calcCircleArea(params[0]);
        } else if (shapeType == 2) {
            return calcSquareArea(params[0]);
        } else if (shapeType == 3 && params.length >= 3) return calcTriangleArea(params);

        return 0.0;
    }

    public static double calcCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double calcSquareArea(double side) {
        return Math.pow(side, 2);
    }

    public static double calcTriangleArea(double... params) {
        double a = params[0];
        double b = params[1];
        double c = params[2];
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new ArithmeticException("Invalid sides Values ");
        }
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }


}

class CalcITest {
    @Test
    void calculateAreaWithWrongArgumentsTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CalcI.calculateArea(4, 2, 1));

    }

    @Test
    void calculateAreaOperationTypeTest() {
        Assertions.assertEquals(12.566, CalcI.calculateArea(1, 2),0.001);
        Assertions.assertEquals(4, CalcI.calculateArea(2, 2));
        Assertions.assertEquals(7.154, CalcI.calculateArea(3, 3, 5, 5),0.001);

    }

    @Test
    void calculateAreaWithNegativeParamsTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> CalcI.calculateArea(3, 2, -1, 8));

    }

    @Test
    void calcCircleAreaTest() {
        Assertions.assertEquals(12.566, CalcI.calcCircleArea(2),0.001);
    }

    @Test
    void calcSquareAreaTest() {
        Assertions.assertEquals(4, CalcI.calcSquareArea(2));
    }

    @Test
    void calcTriangleAreaPositiveTest() {
        Assertions.assertEquals(7.154, CalcI.calcTriangleArea(3, 5, 5),0.001);
    }

    @Test
    void calcTriangleAreaThrowsTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> CalcI.calcTriangleArea(1, 2, 5));
    }
}

