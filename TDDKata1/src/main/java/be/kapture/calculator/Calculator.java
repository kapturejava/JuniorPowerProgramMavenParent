package be.kapture.calculator;

import exceptions.NegativeNumberNotAllowedException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vanmoj1 on 14/04/2017.
 */
public class Calculator {
    private final int MAX_NUMBER = 1000;
    private final String DEFAULT_DELIMITER = "[\\r\\n]|,";
    private final String CUSTOM_DELIMITER = "^//(.*?)\\n";
    private final String NEGATIVE_SIGN = "(.*)-[1-9](.*)";

    int Add(String numbers) {
        String[] intNumbers;
        String delimiter = null;
        int sum = 0;

        if (StringUtils.isNotEmpty(numbers)) {
            if (numbers.matches(NEGATIVE_SIGN)) {
                throw new NegativeNumberNotAllowedException();
            }
            delimiter = getDelimiter(numbers);
            if (!(numbers.contains(",") || numbers.contains("\n"))) {
                return Integer.parseInt(numbers);
            } else {
                if (StringUtils.isEmpty(delimiter)) {
                    intNumbers = numbers.split(DEFAULT_DELIMITER);
                } else {
                    numbers = StringUtils.substringAfter(numbers, "\n");
                    intNumbers = numbers.split(delimiter);
                }
                for (String number : intNumbers) {
                    if (Integer.parseInt(number) <= MAX_NUMBER) {
                        sum += Integer.parseInt(number);
                    }

                }
            }
        } else {
            return sum;
        }

        return sum;
    }

    private String getDelimiter(String regEx) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(regEx);
        String delimiter = null;

        if (matcher.find()) {
            delimiter = Pattern.quote(matcher.group(1));
            System.out.println(delimiter);
        }

        return delimiter;
    }

    private String[] tokenizer(String numbers, String del) {

        return null;
    }
}
