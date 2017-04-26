package be.kapture.calculator;

import exceptions.NegativeNumberNotAllowedException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vanmoj1 on 14/04/2017.
 */
public class Calculator {

    int Add(String numbers) {
        String[] intNumbers;
        String delimiter = null;
        int sum = 0;

        if (StringUtils.isNotEmpty(numbers)) {
            Pattern pattern = Pattern.compile("^//(.*?)\\n");
            Matcher matcher = pattern.matcher(numbers);
            if (numbers.contains("-")) {
                throw new NegativeNumberNotAllowedException();
            }
            if (matcher.find()) {
                delimiter = matcher.group(1);
            }
            if (!(numbers.contains(",") || numbers.contains("\n"))) {
                return Integer.parseInt(numbers);
            } else {
                if (StringUtils.isEmpty(delimiter)) {
                    intNumbers = numbers.split("[\\r\\n]|,");
                } else {
                    numbers = StringUtils.substringAfter(numbers, "\n");
                    intNumbers = numbers.split(delimiter);
                }
                for (String number : intNumbers) {
                    sum += Integer.parseInt(number);
                }
            }
        } else {
            return sum;
        }

        return sum;
    }
}
