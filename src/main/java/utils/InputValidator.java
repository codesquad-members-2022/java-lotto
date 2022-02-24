package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천원단위로 입력해주세요");
        }
    }

    public static void validateAvailablePurchase(int manualLottoEach, int count) {
        if ((count < manualLottoEach) || (manualLottoEach < 0)) {
            throw new IllegalArgumentException("[ERROR] 구매 할 수 없는 숫자입니다. " + count + " 이하의 숫자를 입력하세요.");
        }
    }

    public static void validateNumberOfLotto(String manualLottoNumber) {
        String[] split = manualLottoNumber.split(", ");
        validateCount(split);
        validateRangeAboutAllNumber(split);
        validateOverLapNumber(split);
    }

    private static void validateCount(String[] split) {
        if (split.length != 6) {
            throw new IllegalArgumentException("[ERROR] 적합하지 않은 갯수입니다. 6개를 입력하세요.");
        }
    }

    private static void validateRangeAboutAllNumber(String[] split) {
        for (String s : split) {
            validateRangeAboutSingleNumber(s);
        }
    }

    private static void validateOverLapNumber(String[] split) {
        List<String> list = Arrays.asList(split);
        if(list.size() != list.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 추첨 번호를 중복없이 입력해주세요.");
        }
    }

    public static void validateRangeAboutSingleNumber(String s) {
        if (Integer.parseInt(s) > 45 || Integer.parseInt(s) < 1) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자만 입력해주세요");
        }
    }

}
