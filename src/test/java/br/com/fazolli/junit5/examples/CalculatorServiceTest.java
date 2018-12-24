package br.com.fazolli.junit5.examples;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.*;

@DisplayName("Calculator class test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorServiceTest {

    private CalculatorService calculator;

    @BeforeAll
    void initCalculator() {
        calculator = new CalculatorService();
    }

    @Test
    @DisplayName("Addiction method test")
    @Tag("marca")
    void addiction() throws InvalidArgumentException {
        Assertions.assertEquals(new Double(2D), calculator.addiction(1D, 1D));
    }

    @Test
    @DisplayName("Substraction method test")
    void subtraction() throws InvalidArgumentException {
        Assertions.assertEquals(new Double(0D), calculator.subtraction(1D, 1D));
    }

    @Test
    @DisplayName("Multiplication method test")
    void multiplication() throws InvalidArgumentException {
        Assertions.assertEquals(new Double(1D), calculator.multiplication(1D, 1D));
    }

    @Test
    @DisplayName("Division method success test")
    void division() throws InvalidArgumentException {
        Assertions.assertEquals(new Double(1D), calculator.division(1D, 1D));
    }

    @Test
    @DisplayName("Division by Zero test")
    void divisionByZero() {
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            calculator.division(1D, 0D);
        });
    }

    @Test
    @DisplayName("Division by Null test")
    void divisionByNull() throws InvalidArgumentException {
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            calculator.division(1D, null);
        });
    }
}