package org.example.TESTING.dryKissYagni;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationUtils {
//    public boolean isEmailValid(String email) {
//        String emailRegex = "^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,}$";
//        boolean b = checker(emailRegex);
//        return b;
//    }

    public boolean isPhoneNumberValid(String phoneNumber) {
        String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");

        // Проверка на допустимую длину номера (например, 10 цифр)
        if (digitsOnly.length() != 10) {
            return false;
        }

        // Проверка кода страны (например, должен начинаться с +1.txt для США)
        if (!digitsOnly.startsWith("+1.txt")) {
            return false;
        }

        return true;
    }

    public boolean isPasswordValid(String password) {
        if (password.length() < 8) {
            return false;
        }

        // Пароль должен содержать хотя бы одну заглавную букву (A-Z)
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Пароль должен содержать хотя бы одну строчную букву (a-z)
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Пароль должен содержать хотя бы одну цифру (0-9)
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Пароль должен содержать хотя бы один специальный символ (например, !, @, #, $, %)
        if (!password.matches(".*[!@#$%].*")) {
            return false;
        }

        // Пароль не должен содержать пробелов
        if (password.contains(" ")) {
            return false;
        }

        // Все правила выполнены
        return true;
    }
}

class ValidationUtilsI {

    public boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.startsWith("+1880")) {
            String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");
            return digitsOnly.length() == 10;
        }
        return false;
    }

    public boolean isPasswordValid(String password) {
        if (password.length() > 8) {
            return (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")
                    && password.matches(".*\\d.*") && password.matches(".*[!@#$%].*")
                    && !password.contains(" "));
        }
        return false;
    }
}
class ValidationUtilsITest{
    ValidationUtilsI validationUtilsI = new ValidationUtilsI();

    @Test
    void isPhoneNumberValidTrueTest(){
        Assertions.assertTrue(validationUtilsI.isPhoneNumberValid("+1880123456"));
    }
    @Test
    void isPhoneNumberValidFalseTest(){
        Assertions.assertFalse(validationUtilsI.isPhoneNumberValid("+18801234567"));
    }
    @Test
    void isPasswordValidTrueTest(){
        Assertions.assertTrue(validationUtilsI.isPasswordValid("PAssWORD12@"));
    }
    @Test
    void isPasswordValidFalseTest(){
        Assertions.assertFalse(validationUtilsI.isPasswordValid("PASSWORD12@"));
        Assertions.assertFalse(validationUtilsI.isPasswordValid("PAssWOR D12@"));
    }
}

