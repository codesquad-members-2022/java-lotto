package tddPractice;

import java.util.Arrays;

public class StringAddCalculator {

    public int calculate(String input) {
        if(isEmptyOrNull(input)) {
            return 0;
        }
        String[] numbers = input.split(":|,");
        if (numbers.length == 1) {
            return Integer.parseInt(numbers[0]);
        }
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).reduce(0, Integer::sum);
    }

    private boolean isEmptyOrNull(String value) {
        return value == null || value.isEmpty();
    }
}
