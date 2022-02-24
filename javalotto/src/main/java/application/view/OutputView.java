package application.view;

import java.util.List;

import application.domain.Lotto;
import application.domain.WinningData;

public class OutputView {

    private static final String ENTER_PURCHASE_AMOUNT = "구입 금액을 입력해주세요.";
    private static final String PLEASE_ENTER_YOUR_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_QUANTITY = "개를 구매하셨습니다.";
    private static final String WINNING_STATISTICS = "당첨통계";
    private static final String DIVISION = "---------";
    private static final String ENTER_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String ENTER_NUMBER_OF_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PLEASE_ENTER_YOUR_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private static final int MINIMUM_NUMBER_OF_WINS = 3;
    private static final int MAXIMUM_NUMBER_OF_WINS = 6;
    private static final int INDEX_OF_BONUS_BALL = 7;

    private OutputView() {

    }

    private static void printTotalYield(double totalYield) {
        System.out.printf("총 수익율은 %.2f%%입니다.", totalYield);
    }

    public static void printEnterBonusBall() {
        System.out.println(ENTER_BONUS_BALL);
    }

    public static void printEnterPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
    }

    public static void printPurchaseQuantity(int userPurchaseQuantity) {
        System.out.println(userPurchaseQuantity + PURCHASE_QUANTITY);
    }

    public static void printPurchaseQuantity(int manualQuantity, int autoQuantity) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualQuantity, autoQuantity);
    }

    private static void printLottoNumbers(String lottoString) {
        System.out.println(lottoString);
    }

    public static void printPleaseEnterYourWinningNumber() {
        System.out.println(PLEASE_ENTER_YOUR_WINNING_NUMBER);
    }

    public static void printEnterNumberOfManualLotto() {
        System.out.println(ENTER_NUMBER_OF_MANUAL_LOTTO);
    }

    public static void printPleaseEnterYourManualNumbers() {
        System.out.println(PLEASE_ENTER_YOUR_MANUAL_NUMBERS);
    }

    public static void printWinningStatistics(int[] counts, double totalYield) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVISION);

        for (int winnigCount = MINIMUM_NUMBER_OF_WINS; winnigCount <= MAXIMUM_NUMBER_OF_WINS; winnigCount++) {
            System.out.println(winnigCount + "개 일치 " + "(" + WinningData.getWinningData(winnigCount) + "원)-" + counts[winnigCount] + "개");
            if (winnigCount == 5) {
                System.out.println(winnigCount + "개 일치 ,보너스볼 일치" + "(" + WinningData.getWinningData(INDEX_OF_BONUS_BALL) + "원)-" + counts[INDEX_OF_BONUS_BALL] + "개");
            }
        }
        printTotalYield(totalYield);
    }

    public static void printLottoList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumbers(lotto.lottoNumbersToString());
        }
    }
}
