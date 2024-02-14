package org.example.TESTING.dryKissYagni;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserValidation {
    public boolean validateUsername(String username) {
        // Проверка на длину имени
        if (username.length() < 6 || username.length() > 20) {
            return false;
        }

        // Проверка на наличие специальных символов
        if (!username.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }

        return true;
    }

    public boolean validateEmail(String email) {
        // Проверка на длину email
        if (email.length() < 6 || email.length() > 50) {
            return false;
        }

        // Проверка на наличие символа '@'
        if (!email.contains("@")) {
            return false;
        }

        return true;
    }
}

class UserValidationI {

    public boolean validateUserName(String username) {

        if (username.length() < 6 || username.length() > 20 || !username.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }
        return true;
    }

    public boolean validateEmail(String email) {

        return email.length() >= 6 && email.length() <= 50 && email.contains("@");
    }
}

class UserValidationITest{
    UserValidationI userValidation = new UserValidationI();
    @Test
    void validateUserNameTrueTest() {
    Assertions.assertTrue(userValidation.validateUserName("Anonymous"));

    }
    @Test
    void validateUserNameFalseTest() {
        Assertions.assertFalse(userValidation.validateUserName("Anonymous@"));
        Assertions.assertFalse(userValidation.validateUserName("nony"));
        Assertions.assertFalse(userValidation.validateUserName("AnonymousSuperLongName"));
    }
    @Test
    void validateEmailTrueTest() {
        Assertions.assertTrue(userValidation.validateEmail("email@example.com"));
    }
    @Test
    void validateEmailFalseTest() {
        Assertions.assertFalse(userValidation.validateEmail("email@emailemailemailemailemailemailemailemailemailemailemailemailemailemail"));
        Assertions.assertFalse(userValidation.validateEmail("email%example.com"));
        Assertions.assertFalse(userValidation.validateEmail("em@il"));
    }
}

