package application.view;

import application.domain.User;

public class InputValidator {

    public static boolean validateNumberFormat(String str) throws IllegalArgumentException {

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.\n");
        }
        return true;
    }

    public static void validateManualCount(int money, int manualCount) throws IllegalArgumentException {
        if (money < manualCount * User.PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

}
