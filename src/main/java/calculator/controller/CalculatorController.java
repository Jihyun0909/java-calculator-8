package calculator.controller;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    public void run() {
        String input = readInput();
        // 다음 단계에서 StringAddCalculator.add(input) 호출로 교체
        printResult(0); // 임시 출력
    }

    private String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
