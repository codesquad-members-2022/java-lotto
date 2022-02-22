package application.view;

import java.util.List;

import application.domain.WinningData;

public class OutputView {

    private static final String ENTER_PURCHASE_AMOUNT = "구입 금액을 입력해주세요.";
    private static final String PLEASE_ENTER_YOUR_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_QUANTITY = "개를 구매하셨습니다.";
    private static final String WINNING_STATISTICS = "당첨통계";
    private static final String DIVISION = "---------";
    private static final String ENTER_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private static final int MINIMUM_NUMBER_OF_WINS = 3;
    private static final int MAXIMUM_NUMBER_OF_WINS = 6;

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

    public static void printLottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void printPleaseEnterYourWinningNumber() {
        System.out.println(PLEASE_ENTER_YOUR_WINNING_NUMBER);
    }

    public static void printWinningStatistics(int[] counts, double totalYield) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVISION);

        for (int i = MINIMUM_NUMBER_OF_WINS; i <= MAXIMUM_NUMBER_OF_WINS; i++) {
            System.out.println(i + "개 일치 " + "(" + WinningData.getWinningData(i) + "원)-" + counts[i] + "개");
            if (i == 5) {
                System.out.println(i + "개 일치 ,보너스볼 일치" + "(" + WinningData.getWinningData(7) + "원)-" + counts[7] + "개");
            }
        }
        printTotalYield(totalYield);
    }
}
