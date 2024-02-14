package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

// Нарушение KISS:
class StringUtils {
    public static String toUpperCase(String input) {
        // Сложная реализация для простой операции
        // ...
        return input.chars()
                .mapToObj(Character::toString)
                .map(s -> {
                    // Добавляем дополнительную логику преобразования, например, пропуск знаков препинания
                    if (s.equals(" ")) {
                        return " ";
                    } else {
                        return s.toUpperCase();
                    }
                })
                .collect(Collectors.joining());
    }
}

class StringUtilsI {
    public static String toUpperCase(String input) {
        return input.toUpperCase();
    }
}

class StringUtilsTest {
    @Test
    void toUpperCaseTest() {
        Assertions.assertEquals("HELLO", StringUtils.toUpperCase("hello"));
    }
}