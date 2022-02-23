package domain;

public class LottoCashier {

    private static final int LOTTO_PRICE = 1_000;

    public static int getLottoAmount(int purchasingAmount) {
        validatePurchasingAmount(purchasingAmount);
        return purchasingAmount / LOTTO_PRICE;
    }

    private static void validatePurchasingAmount(int purchasingAmount) {
        if (purchasingAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구매할 돈이 부족합니다!!");
        }
    }
}
