package utils;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBER_REGEX = "^[0-9]*$"; //숫자만
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    public static void validatePrice(String price) {
        if (!NUMBER_PATTERN.matcher(price).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }
    }
}
