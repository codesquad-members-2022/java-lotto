package lotto.view;

import java.util.*;

public class InputView {
    private static Scanner sc;
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String REQUIRED_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";


    public static int getPurchaseAmount() {
        try {
            System.out.println(PURCHASE_AMOUNT_MESSAGE);
            String input = sc.nextLine();
            if (InputValidator.validateInputAllNumber(input)) {
                return Integer.parseInt(input);
            }
        } catch (IllegalArgumentException ne) {
            System.err.println(ne.getMessage());
        }

        return getPurchaseAmount();
    }

    public static int getManualLottoCount() {
        try {
            System.out.println(MANUAL_LOTTO_COUNT_MESSAGE);
            String input = sc.nextLine();
            if (InputValidator.validateInputManualLottoCount(input)) {
                return Integer.parseInt(input);
            }
        } catch (IllegalArgumentException ne) {
            System.err.println(ne.getMessage());
        }

        return getManualLottoCount();
    }

    public static Map<Integer, String>  getManualLottoNumbers(int manualLottoCount) {
        System.out.println(MANUAL_LOTTO_NUMBERS_MESSAGE);
        Map<Integer,String> manualLottoNumbers = new HashMap<>();

        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoNumbers.put(i, sc.nextLine());
        }

        return manualLottoNumbers;
    }

    public static String getRequiredWinningNumber() {
        System.out.println(REQUIRED_WINNING_NUMBER_MESSAGE);
        return sc.nextLine();
    }

    public static String getBonusBallNumber(List<Integer> winningNumbers) {
        try {
            System.out.println(BONUS_BALL_NUMBER_MESSAGE);
            String bonusBall = sc.nextLine();
            InputValidator.validateIsNumber(bonusBall);
            InputValidator.validateDuplicateWinningNumber(winningNumbers, bonusBall);

            return bonusBall;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        return getBonusBallNumber(winningNumbers);
    }

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }
}
