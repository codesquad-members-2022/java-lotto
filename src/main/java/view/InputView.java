package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String PROMPT = "> ";
    private static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_ANSWER = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner sc = new Scanner(System.in);

    private static InputValidator validator = new InputValidator();

    public int getMoneyInput() {
        System.out.println(PROMPT_MONEY);
        System.out.print(PROMPT);
        try {
            return validator.validateInteger(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoneyInput();
        }
    }

    public List<Integer> getWinningNumberInput() {
        System.out.println(PROMPT_ANSWER);
        System.out.print(PROMPT);
        try {
            return validator.validateWinningNumber(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumberInput();
        }
    }

    public int getBonusNumberInput(List<Integer> winningNumber) {
        System.out.println(PROMPT_BONUS_NUMBER);
        System.out.print(PROMPT);
        try {
            int bonusNumber = validator.validateInteger(sc.nextLine());
            return validator.validateBonusNumber(winningNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumberInput(winningNumber);
        }
    }
}
