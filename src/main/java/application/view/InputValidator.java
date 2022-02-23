package application.view;

import application.domain.UserBundle;

public class InputValidator {

    public static boolean validateNumberFormat(String str) throws IllegalArgumentException {

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.\n");
        }
        return true;
    }

    public static void validateManualCount(int money, int manualCount) {
        if (money < manualCount * UserBundle.PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

}
