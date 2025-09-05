package com.tp2.password;

import java.util.regex.Pattern;

public class PasswordValidator {

    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        boolean hasMinLength = password.length() >= 8;

        boolean hasUppercase = !password.equals(password.toLowerCase());

        boolean hasLowercase = !password.equals(password.toUpperCase());

        boolean hasDigit = password.matches(".*\\d.*");

        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?]");
        boolean hasSpecialChar = specialCharPattern.matcher(password).find();

        return hasMinLength && hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }
}
