package calculator.service;

import calculator.support.InputParser;
import calculator.support.Validators;

import java.util.List;

public final class StringAddCalculator {
    private StringAddCalculator() {}

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        List<String> tokens = InputParser.parseToTokens(input);
        List<Integer> numbers = Validators.toValidatedPositiveIntegers(tokens);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
