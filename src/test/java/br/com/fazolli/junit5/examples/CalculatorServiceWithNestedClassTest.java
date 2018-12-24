package br.com.fazolli.junit5.examples;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.*;

@DisplayName("Calculator class test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorServiceWithNestedClassTest {

    private CalculatorService calculator;

    @BeforeAll
    void initCalculator() {
        calculator = new CalculatorService();
    }

    @Nested
    @DisplayName("Calculator Addiction test")
    class Addiction {
        @Test
        @DisplayName("Addiction method test")
        @Tag("marca")
        void addiction() throws InvalidArgumentException {
            Assertions.assertEquals(new Double(2D), calculator.addiction(1D, 1D));
        }
    }

    @Nested
    @DisplayName("Calculator Subtraction test")
    class Subtraction {
        @Test
        @DisplayName("Substraction method test")
        void subtraction() throws InvalidArgumentException {
            Assertions.assertEquals(new Double(0D), calculator.subtraction(1D, 1D));
        }
    }

    @Nested
    @DisplayName("Calculator Multiplication test")
    class Multiplication {
        @Test
        @DisplayName("Multiplication method test")
        void multiplication() throws InvalidArgumentException {
            Assertions.assertEquals(new Double(1D), calculator.multiplication(1D, 1D));
        }
    }

    @Nested
    @DisplayName("Calculator Division test")
    class Division {

        @Nested
        @DisplayName("Calculator Division Success")
        class DivisionSucess {

            @Test
            @DisplayName("Division method success test")
            void division() throws InvalidArgumentException {
                Assertions.assertEquals(new Double(1D), calculator.division(1D, 1D));
            }

        }

        @Nested
        @DisplayName("Calculator Division Errors")
        class DivisionError {

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

    }

}