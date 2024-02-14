package org.example.TESTING.dryKissYagni;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class CircleQ {
    private double radius;

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}

class CircleQI {
    public static void main(String[] args) {
        System.out.println(calculateCircumference());
    }

    private static double radius;

    public static double calculateArea() {

        return Math.PI * Math.pow(radius, 2);
    }

    public static double calculateCircumference() {

        return 2 * Math.PI * radius;
    }

}

class CircleQITest {
    @Mock
    CircleQI circleQI = Mockito.mock(CircleQI.class);

    @Test
    void calculateAreaTest() {
        circleQI.calculateArea();
        Mockito.verify(circleQI).calculateArea();
    }

    @Test
    void calculateCircumferenceTest() {
        circleQI.calculateCircumference();
        Mockito.verify(circleQI).calculateCircumference();
    }
}
