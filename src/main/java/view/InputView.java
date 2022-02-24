package view;

import java.util.List;
import java.util.Scanner;

import exception.LottoIllegalInputException;

public class InputView {

    private static final String PROMPT = "> ";
    private static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PROMPT_ANSWER = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final InputValidator validator = InputValidator.getInstance();

    private final Scanner sc;

    public InputView(Scanner sc) {
        this.sc = sc;
    }

    public int getMoneyInput() {
        System.out.println(PROMPT_MONEY);
        System.out.print(PROMPT);
        try {
            return validator.validatePositiveInteger(sc.nextLine());
        } catch (LottoIllegalInputException e) {
            System.out.println(e.getMessage());
            return getMoneyInput();
        }
    }

    public List<Integer> getLottoNumbersInput() {
        System.out.println(PROMPT_ANSWER);
        System.out.print(PROMPT);
        try {
            return validator.validateWinningNumber(sc.nextLine());
        } catch (LottoIllegalInputException e) {
            System.out.println(e.getMessage());
            return getLottoNumbersInput();
        }
    }

    public int getBonusNumberInput(List<Integer> winningNumber) {
        System.out.println(PROMPT_BONUS_NUMBER);
        System.out.print(PROMPT);
        try {
            return validator.validateBonusNumber(winningNumber, sc.nextLine());
        } catch (LottoIllegalInputException e) {
            System.out.println(e.getMessage());
            return getBonusNumberInput(winningNumber);
        }
    }

    public int getManualLottoCountInput(int userMoney) {
        System.out.println(PROMPT_MANUAL_LOTTO_COUNT);
        System.out.print(PROMPT);
        try {
            return validator.validateManualLottoCount(userMoney, sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualLottoCountInput(userMoney);
        }
    }
}
