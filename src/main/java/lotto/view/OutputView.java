package lotto.view;

public class OutputView {

    private static final String PURCHASED_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void printPurchaseCount(int lottoSize) {
        System.out.println(lottoSize + PURCHASED_COUNT_MESSAGE);
    }

    public static void printLottoPaper(String lottoPaper) {
        System.out.println(lottoPaper);
    }
}
