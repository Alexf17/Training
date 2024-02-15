package org.example.TESTING._2024_02_15_morning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ComplexOperationsServiceTest {

    private final ComplexOperationsService service = new ComplexOperationsService();

    @ParameterizedTest
    @CsvSource({
            "weak, false",
            "strongPassword1@, true",
            "noDigit!, false",
            "NoSpecialChar1, false"
    })
    void validatePasswordStrength(String password, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.validatePasswordStrength(password));
        } else {
            assertDoesNotThrow(() -> service.validatePasswordStrength(password));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"This is correct", "This text contains error", "fail is not good", "wrong way"})
    void processText(String text) {
        if (text.contains("error") || text.contains("fail") || text.contains("wrong")) {
            assertThrows(IllegalArgumentException.class, () -> service.processText(text));
        } else {
            assertDoesNotThrow(() -> service.processText(text));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"weak", "noDigit!", "NoSpecialChar1"})
    void validatePasswordExceptionStrength(String password) {
        assertThrows(IllegalArgumentException.class, () -> service.validatePasswordStrength(password));
    }

    @Test
    void validatePasswordStrength() {
        assertDoesNotThrow(() -> service.validatePasswordStrength("strongPassword1@"));
    }

    @ParameterizedTest
    @CsvSource({"'1,2,3' , true", "'1,O,3' , false", "'4,5,o' , false"})
    void sumOfNumbersInStringExceptionTest(String params, boolean isCorrect) {
        if (!isCorrect) {
            assertThrows(IllegalArgumentException.class, () -> service.sumOfNumbersInString(params));
        } else {
            assertDoesNotThrow(() -> service.sumOfNumbersInString(params));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://google.com", "https://ebay.com"})
    void validateUrlFormatTest(String params) {
        assertThrows(IllegalArgumentException.class, () -> service.validateUrlFormat(params));
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://google.com", "https://ebay.com", "htps://ebay"})
    void validateUrlFormatExceptionTest(String params) {
        if (!params.matches("^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}.*$")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateUrlFormat(params));
        } else {
            assertDoesNotThrow(() -> service.validateUrlFormat(params));
        }

    }

    public static Stream<Arguments> emailListProvider() {
        return Stream.of(
//                Arguments.of((Object) new String[]{"Black"}),
//                Arrays.asList("valid@email.com", "invalid-email"), false,
                Arguments.of(Arrays.asList("valid@email.com", "invalid-email"), false),
                Arguments.of(Arrays.asList("valid@email.com", "also.valid@email.com"), true)
        );
    }

    @ParameterizedTest
    @MethodSource("emailListProvider")
    void checkEmailListConsistency(List<String> emails, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.checkEmailListConsistency(emails));
        } else {
            assertDoesNotThrow(() -> service.checkEmailListConsistency(emails));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"А роза упала на лапу азора", "Heeh", "heOeH"})
    void checkStringPalindromeTest(String params) {
        assertDoesNotThrow(() -> service.checkStringPalindrome(params));
    }

    @ParameterizedTest
    @ValueSource(strings = {"HelloH", "Wereww", "trest"})
    void checkStringPalindromeExceptionTest(String params) {
        assertThrows(IllegalArgumentException.class, () -> service.checkStringPalindrome(params));
    }

    @ParameterizedTest
    @ValueSource(strings = {"AB123456", "AB12345", "SA123456", "AB1234567"})
    void validateIdentificationNumberTest(String id) {
        if (!id.matches("^[A-Za-z]{2}\\d{6}$")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateIdentificationNumber(id));
        }
        assertDoesNotThrow(() -> service.validateIdentificationNumber(id));
    }

    public static Stream<Arguments> numberListProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 14, true),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 16, false),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 12, true),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 18, false)
        );
    }

    @ParameterizedTest
    @MethodSource("numberListProvider")
    void checkSumOfListAgainstThresholdTest(List<Integer> numbers, int threshold, boolean isCorrect) {
        if (!isCorrect) {
            assertThrows(IllegalArgumentException.class, () -> service.checkSumOfListAgainstThreshold(numbers, threshold));
        } else {
            assertDoesNotThrow(() -> service.checkSumOfListAgainstThreshold(numbers, threshold));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"101.102.103.104", "101.102.103", "1.102.1.104", ".103.104"})
    void validateIPAddressTest(String ipAddress) {
        if (!ipAddress.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateIPAddress(ipAddress));
        } else {
            assertDoesNotThrow(() -> service.validateIPAddress(ipAddress));
        }
    }

    public static Stream<Arguments> listProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), true),
                Arguments.of(Arrays.asList(1, 3, 3, 4, 5), false),
                Arguments.of(Arrays.asList("A", "B", "c", "d", "e"), true),
                Arguments.of(Arrays.asList("A", "B", "c", "d", "D"), true)
        );
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    void ensureNoDuplicateEntriesTest(List<String> entries, boolean isCorrect) {
        if (!isCorrect) {
            assertThrows(IllegalArgumentException.class, () -> service.ensureNoDuplicateEntries(entries));
        } else {
            assertDoesNotThrow(() -> service.ensureNoDuplicateEntries(entries));
        }
    }


}


// For checkEmailListConsistency and other methods requiring complex inputs or multiple parameters,
// you might use @MethodSource to supply a Stream of arguments.
// Example setup for @MethodSource (not fully implemented due to complexity):
// public static Stream<Arguments> emailListProvider() {
//     return Stream.of(
//         Arguments.of(Arrays.asList("valid@email.com", "invalid-email"), false),
//         Arguments.of(Arrays.asList("valid@email.com", "also.valid@email.com"), true)
//     );
// }

// Example test method using @MethodSource for email lists
// @ParameterizedTest
// @MethodSource("emailListProvider")
// void checkEmailListConsistency(List<String> emails, boolean isValid) {
//     if (!isValid) {
//         assertThrows(IllegalArgumentException.class, () -> service.checkEmailListConsistency(emails));
//     } else {
//         // Assume no exception for valid email lists
//     }
// }

// Continue writing tests for the remaining methods follo
