package be.kapture;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static final List<String> SPECIAL_CHARACTERS = Arrays.asList("+", "[", "*", ".", "^");

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (StringUtils.endsWith(numbers, "\n")) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.startsWith(numbers, "//")) {
            int endDelimiter = numbers.indexOf("\n");
            String regex = getRegex(numbers, endDelimiter);
            return calculate(numbers.substring(endDelimiter + 1), regex);
        }
        return calculate(numbers, ",|\n");
    }

    private String getRegex(String numbers, int endDelimiter) {
        String substring = numbers.substring(2, endDelimiter);
        String regex = "";
        for (String string : substring.split("")) {
            if (SPECIAL_CHARACTERS.contains(string)) {
                    regex += "\\" + string;
            } else {
                regex += string;
            }
        }
        return regex + "|\n";
    }


    private int calculate(String numbers, String regex) {
        String[] split = numbers.split(regex);
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
