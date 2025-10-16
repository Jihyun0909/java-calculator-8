package calculator.support;

import java.util.ArrayList;
import java.util.List;

public final class Validators {
    private Validators() {}

    public static List<Integer> toValidatedPositiveIntegers(List<String> tokens) {
        List<Integer> out = new ArrayList<>(tokens.size());
        for (String t : tokens) {
            if (t.isEmpty()) {
                throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
            }
            if (!isAllDigits(t)) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + t);
            }
            int v = parseIntSafe(t);
            // 정책: 양수만 허용 (0/음수 → 예외)
            if (v <= 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다: " + v);
            }
            out.add(v);
        }
        return out;
    }

    private static boolean isAllDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    private static int parseIntSafe(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 정수 범위입니다: " + s);
        }
    }
}
