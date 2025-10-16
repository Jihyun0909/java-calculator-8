package calculator.service;

import calculator.support.InputParser;

import java.util.List;

public final class StringAddCalculator {
    private StringAddCalculator() {}

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        List<String> tokens = InputParser.parseToTokens(input);
        // 다음 단계에서 검증+합산
        return 0;
    }
}
