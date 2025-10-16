package calculator.support;

import java.util.ArrayList;
import java.util.List;

public final class Validators {
    private Validators() {}

    /**
     * 문자열 토큰 리스트를 검증하고 양의 정수 리스트로 변환한다.
     * 예외 상황:
     *  - 빈 입력("") → 빈 리스트 반환 (결과 0)
     *  - 숫자가 아닌 값 → IllegalArgumentException
     *  - 0 또는 음수 → IllegalArgumentException
     *  - 빈 토큰(예: "1,,2") → IllegalArgumentException
     */
    public static List<Integer> toValidatedPositiveIntegers(List<String> tokens) {
        // 1. 입력 자체가 없거나 공백이라면 빈 리스트 반환 (결과: 0)
        if (tokens == null || tokens.isEmpty() ||
                (tokens.size() == 1 && tokens.get(0).isBlank())) {
            return new ArrayList<>(); // 결과 0
        }

        List<Integer> out = new ArrayList<>(tokens.size());
        for (String t : tokens) {
            // 2. 빈 토큰 처리 ("1,,2" 등)
            if (t == null || t.isBlank()) {
                throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
            }

            // 3. 숫자 외 문자가 포함된 경우 ("a,1" 등)
            if (!isAllDigits(t)) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + t);
            }

            // 4. 숫자 변환 시 예외 처리
            int v = parseIntSafe(t);

            // 5. 0 이하 금지 ("0,1" 등)
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
