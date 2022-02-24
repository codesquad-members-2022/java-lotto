package utils;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBER_REGEX = "^[0-9]*$"; //숫자만
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    public static void validateNumber(String price) {
        if (!NUMBER_PATTERN.matcher(price).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }
    }

    public static void validatePriceUnit(int price) {
        if (price % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 천원단위로 입력해주세요");
        }
    }

    public static void validateAvailablePurchase(int manualLottoEach, int count) {
        if ((count < manualLottoEach) || (manualLottoEach < 0)) {
            throw new IllegalArgumentException("[ERROR] 만들 수 없는 숫자입니다. " + count + " 이하의 숫자를 입력하세요.");
        }
    }
}
