package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class D1 {

    public double calculateAverageValueForGivenList(List<Double> listOfNumbers) {
        double sumOfAllValues = 0;
        for (double currentValue : listOfNumbers) {
            sumOfAllValues += currentValue;
        }
        return sumOfAllValues / listOfNumbers.size();
    }
}

class D1I {


    public static double calculateAverageValueForGivenList(List<Double> listOfNumbers) {
        if (listOfNumbers == null || listOfNumbers.isEmpty()) {
            throw new IllegalArgumentException("List cant be empty");
        }
        double sumOfAllValues = 0;
        for (double currentValue : listOfNumbers) {
            sumOfAllValues += currentValue;
        }

        return sumOfAllValues / listOfNumbers.size();
    }


}
class D1ITest{
    @Test
    void calculateAverageValueForGivenListTest() {
        Assertions.assertEquals(4, D1I.calculateAverageValueForGivenList(Arrays.asList(2.0, 6.0, 4.0)));
    }

    @Test
    void calculateAverageValueForGivenListWithNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> D1I.calculateAverageValueForGivenList(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> D1I.calculateAverageValueForGivenList(Arrays.asList()));
    }
}


