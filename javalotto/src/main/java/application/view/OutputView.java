package application.view;

import java.util.List;

import application.domain.WinningData;

public class OutputView {

    private static final String ENTER_PURCHASE_AMOUNT = "구입 금액을 입력해주세요.";
    private static final String PLEASE_ENTER_YOUR_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_QUANTITY = "개를 구매하셨습니다.";
    private static final String WINNING_STATISTICS = "당첨통계";
    private static final String DIVISION = "---------";

    private OutputView() {

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

    public static void printWinningStatistics(int[] counts) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVISION);
        for (int i = 3; i < 7; i++) {
            System.out.println(i + "개 일치 " + "(" + WinningData.getWinningData(i) + "원)-" + counts[i] + "개");
        }
    }
}
