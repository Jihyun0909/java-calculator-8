package calculator.support;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {
    private static final String DEFAULT_DELIMS_REGEX = "[,:]";
    private static final Pattern CUSTOM_HEADER = Pattern.compile("^//(.+)\\n(.*)$", Pattern.DOTALL);

    private InputParser() {}

    public static List<String> parseToTokens(String raw) {
        Matcher m = CUSTOM_HEADER.matcher(raw);
        if (m.matches()) {
            String customDelim = m.group(1);
            String numberPart  = m.group(2);
            String regex = Pattern.quote(customDelim); // 특수문자 안전
            return split(numberPart, regex);
        }
        return split(raw, DEFAULT_DELIMS_REGEX);
    }

    private static List<String> split(String s, String regex) {
        String[] arr = s.split(regex, -1);
        List<String> out = new ArrayList<>(arr.length);
        for (String t : arr) out.add(t.trim());
        return out;
    }
}
