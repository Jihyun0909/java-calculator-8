package calculator.support;

import java.util.ArrayList;
import java.util.List;

public final class InputParser {
    private static final String DEFAULT_DELIMS_REGEX = "[,:]";

    private InputParser() {}

    public static List<String> parseToTokens(String raw) {
        String[] arr = raw.split(DEFAULT_DELIMS_REGEX, -1); // 빈 토큰 보존
        List<String> out = new ArrayList<>(arr.length);
        for (String s : arr) out.add(s.trim());
        return out;
    }
}
