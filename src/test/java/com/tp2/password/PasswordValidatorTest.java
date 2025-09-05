package com.tp2.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Password Validator Test")
class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    @DisplayName("Paso 1: Longitud mínima")
    void passwordIsInvalidIfLessThan8Chars() {
        assertFalse(validator.isValid("Short1!"));
    }

    @Test
    @DisplayName("Paso 2: Letra mayúscula requerida")
    void passwordIsInvalidWithoutUppercaseLetter() {
        assertFalse(validator.isValid("nouppercase1!"));
    }

    @Test
    @DisplayName("Paso 3: Letra minúscula requerida")
    void passwordIsInvalidWithoutLowercaseLetter() {
        assertFalse(validator.isValid("NOLOWERCASE1!"));
    }

    @Test
    @DisplayName("Paso 4: Número requerido")
    void passwordIsInvalidWithoutNumber() {
        assertFalse(validator.isValid("NoNumberPass!"));
    }

    @Test
    @DisplayName("Paso 5: Carácter especial requerido")
    void passwordIsInvalidWithoutSpecialCharacter() {
        assertFalse(validator.isValid("NoSpecial123"));
    }

    @Test
    @DisplayName("Paso 6: Contraseña válida completa")
    void passwordIsValidWhenAllCriteriaAreMet() {
        assertTrue(validator.isValid("ValidPass1!"));
        assertTrue(validator.isValid("Another$ecret123"));
    }
}