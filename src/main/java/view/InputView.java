package view;

import exception.LottoIllegalInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String PROMPT = "> ";
    private static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PROMPT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
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

    public List<Integer> getWinningNumbersInput() {
        System.out.println(PROMPT_WINNING_NUMBERS);
        System.out.print(PROMPT);
        try {
            return validator.validateLottoNumbers(sc.nextLine());
        } catch (LottoIllegalInputException e) {
            System.out.println(e.getMessage());
            return getWinningNumbersInput();
        }
    }

    public List<List<Integer>> getManualNumbersInput(int manualLottoCount) {
        System.out.println(PROMPT_MANUAL_LOTTO_NUMBERS);
        System.out.print(PROMPT);
        try {
            List<List<Integer>> manualNumbersList = new ArrayList<>();
            for (int i = 0; i < manualLottoCount; i++) {
                manualNumbersList.add(validator.validateLottoNumbers(sc.nextLine()));
            }
            return manualNumbersList;
        } catch (LottoIllegalInputException e) {
            System.out.println(e.getMessage());
            return getManualNumbersInput(manualLottoCount);
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
        } catch (LottoIllegalInputException e) {
            System.out.println(e.getMessage());
            return getManualLottoCountInput(userMoney);
        }
    }
}
