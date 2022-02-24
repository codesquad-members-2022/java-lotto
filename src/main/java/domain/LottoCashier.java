package domain;

public class LottoCashier {

    public static final int LOTTO_PRICE = 1_000;

    public static int getLottoAmount(int purchasingAmount) {
        return purchasingAmount / LOTTO_PRICE;
    }
}
