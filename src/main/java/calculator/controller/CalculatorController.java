package calculator.controller;

import camp.nextstep.edu.missionutils.Console;
import calculator.service.StringAddCalculator;

public class CalculatorController {

    public void run() {
        String input = readInput();
        int result = StringAddCalculator.add(input);
        printResult(result);
    }

    private String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
