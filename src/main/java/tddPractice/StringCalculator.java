package tddPractice;

import java.util.stream.IntStream;

public class StringCalculator {

    public static double calculate(String input) { // 1 + 2 * 3 / 4
        String[] splited = input.split(" ");
        double[] doubles = pickNumber(splited);
        String[] operators = pickOperator(splited);
        double result = Double.parseDouble(splited[0]);
        for (int i = 0; i < operators.length; i++) {
            if(operators[i].equals("+")) {
                result = add(result, doubles[i + 1]);
            }
            if(operators[i].equals("-")) {
                result = subtract(result, doubles[i + 1]);
            }
            if(operators[i].equals("*")) {
                result = multiply(result, doubles[i + 1]);
            }
            if(operators[i].equals("/")) {
                result = divide(result, doubles[i + 1]);
            }
        }
        return result;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (a == 0 || b == 0) {
            throw new IllegalArgumentException("0은 나눌 수 없습니다.");
        }
        return a / b;
    }

    private static String[] pickOperator(String[] input) {
        return IntStream.range(0, input.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> input[i])
                .toArray(String[]::new);
    }

    private static double[] pickNumber(String[] input) {
        return IntStream.range(0, input.length)
                .filter(i -> i % 2 == 0)
                .mapToDouble(i -> Double.parseDouble(input[i]))
                .toArray();
    }
}
