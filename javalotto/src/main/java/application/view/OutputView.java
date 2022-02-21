package application.view;

public class OutputView {

    private static final String ENTER_PURCHASE_AMOUNT = "구입 금액을 입력해주세요.";
    private static final String PLEASE_ENTER_YOUR_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_QUANTITY = "개를 구매하셨습니다.";

    private OutputView() {

    }

    public static void printEnterPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
    }

    public static void printPurchaseQuantity(int userPurchaseQuantity) {
        System.out.println(userPurchaseQuantity + PURCHASE_QUANTITY);
    }
}
