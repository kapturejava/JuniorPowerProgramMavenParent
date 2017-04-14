package be.kapture.calculator;

/**
 * Created by vanmoj1 on 14/04/2017.
 */
public class Calculator {

    int Add(String numbers) {
        int sum = 0;
        if (numbers.isEmpty()) {
            sum = 0;
        } else if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        } else {
            Integer int1 = Integer.parseInt(numbers.substring(0, 1));
            Integer int2 = Integer.parseInt(numbers.substring(2, 3));

            sum = int1 + int2;
        }

        return sum;
    }
}
