package lotto.domain;

import java.util.stream.Stream;

public class InputParser {
    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수로 변환할 수 없는 문자열이 입력되었습니다");
        }
    }

    public static int[] parseIntArray(String[] input) {
        return Stream.of(input).mapToInt(InputParser::parseInt).toArray();
    }

}
