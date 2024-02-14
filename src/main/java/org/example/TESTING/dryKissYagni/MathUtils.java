package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class MathUtils {
    public static int calculateSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }
}

class MathUtilsI {
    /**
     * пытался сделать один универсальный метод , но видимо пока знаний недостаточно
     */
    public static int calculateSum(int[] numbers) {
        if(numbers == null){
            throw new IllegalArgumentException("array must not be null");
        }
        return Arrays.stream(numbers).sum();
    }

    public static int calculateSum(List<Integer> numbers) {
        if(numbers == null){
            throw new IllegalArgumentException("list must not be null");
        }
        return numbers.stream().mapToInt(e -> e).sum();
    }
}

class MathUtilsITest {
    @Test
    void calculateSumWithArrTest() {
        Assertions.assertEquals(9,MathUtilsI.calculateSum(new int[]{2, 3, 4}));
    }
    @Test
    void calculateSumWithListTest() {
        Assertions.assertEquals(9,MathUtilsI.calculateSum(Arrays.asList(2, 3, 4)));
    }
    @Test
    void calculateSumWithNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MathUtilsI.calculateSum((int[]) null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> MathUtilsI.calculateSum((List<Integer>) null));
    }
}