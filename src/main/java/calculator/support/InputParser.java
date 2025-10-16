package calculator.support;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {
    private InputParser() {}

    private static final String DEFAULT_DELIMS_REGEX = "[,:]";

    // //X\n or //X\\n  (둘 다 인식)
    private static final Pattern CUSTOM_HEADER = Pattern.compile("^//(.)(?:\\\\n|\\n)(.*)$", Pattern.DOTALL);

    public static List<String> parseToTokens(String raw) {
        if (raw == null || raw.isBlank()) {
            return new ArrayList<>();
        }

        Matcher m = CUSTOM_HEADER.matcher(raw);
        if (m.matches()) {
            String customDelim = m.group(1);
            String numberPart = m.group(2);
            String regex = Pattern.quote(customDelim);
            return split(numberPart, regex);
        }

        return split(raw, DEFAULT_DELIMS_REGEX);
    }

    private static List<String> split(String s, String regex) {
        String[] arr = s.split(regex, -1); // 빈 토큰 유지
        List<String> out = new ArrayList<>(arr.length);
        for (String t : arr) {
            out.add(t.trim());
        }
        return out;
    }
}
