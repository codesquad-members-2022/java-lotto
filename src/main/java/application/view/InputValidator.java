package application.view;

public class InputValidator {

    public static boolean validateNumberFormat(String str) throws IllegalArgumentException {

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.\n");
        }
        return true;
    }
}
