package br.com.fazolli.junit5.examples;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class CalculatorService {

    public Double addiction(Double first, Double second) throws InvalidArgumentException {
        validParameters(first, second);
        return first + second;
    }

    public Double subtraction(Double first, Double second) throws InvalidArgumentException {
        validParameters(first, second);
        return first - second;
    }

    public Double multiplication(Double first, Double second) throws InvalidArgumentException {
        validParameters(first, second);
        return first * second;
    }

    public Double division(Double first, Double second) throws InvalidArgumentException {
        validParametersToDivision(first, second);
        return first / second;
    }

    private void validParameters(Double first, Double second) throws InvalidArgumentException {
        if (first == null || second == null) {
            throw new InvalidArgumentException(new String[]{"Invalid Argument"});
        }
    }

    private void validParametersToDivision(Double first, Double second) throws InvalidArgumentException {
        validParameters(first, second);
        if (second == 0D) {
            throw new InvalidArgumentException(new String[]{"Invalid Argument"});
        }
    }
}
