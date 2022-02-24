package application.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {

    public static int parseNumber(String str) {
        InputValidator.validateNumberFormat(str);
        return Integer.parseInt(str);
    }

    public static List<Integer> parseListNumber(String str) {
        return Arrays.stream(str.trim().split(","))
                .peek(InputValidator::validateNumberFormat)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> parseDoubleListNumber(String str) {
        return Arrays.stream(str.split("\n"))
                    .map(InputUtil::parseListNumber)
                    .collect(Collectors.toList());
    }
}
