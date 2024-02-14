package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Нарушение CODE SMELLS:
class DAta {
    public  double calculateAverage(List<Double> numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }

        double average = sum / numbers.size();

        double variance = 0;
        for (double num : numbers) {
            variance += Math.pow(num - average, 2);
        }
        double standardDeviation = Math.sqrt(variance / numbers.size());

        return standardDeviation;
    }
}

class DAtaI {

    public static double calculateAverage(List<Double> numbers) {
        double sum = 0;
        double sumOfPow = 0;
        for (double num : numbers) {
            sum += num;
            sumOfPow += Math.pow(num, 2);
        }
        double average = sum / numbers.size();

        return sumOfPow / numbers.size() - Math.pow(average, 2);
    }


}
class DAtaITest{
    @Test
    void calculateAverageTest() {
        Assertions.assertEquals(1.333, DAtaI.calculateAverage(Arrays.asList(5.0, 2.0, 3.0, 5.0, 4.0, 5.0)),0.001);
    }
}

