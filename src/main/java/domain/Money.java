package domain;

public class Money {

    private static final long PRICE_OF_LOTTO = 1000;

    private final long purchaseAmount;

    public Money(long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        validateRangeOfPurchaseAmount(purchaseAmount);
        validateMultipleOfPrice(purchaseAmount);
    }

    private void validateMultipleOfPrice(long purchaseAmount) {
        if (isMultipleOfPrice(purchaseAmount)) {
            return;
        }
        throw new IllegalArgumentException(String.format("구입금액은 %d의 배수만 가능합니다.", PRICE_OF_LOTTO));
    }

    private boolean isMultipleOfPrice(long purchaseAmount) {
        return purchaseAmount % 1000 == 0;
    }

    private void validateRangeOfPurchaseAmount(long purchaseAmount) {
        if (isValidRangeOfPurchaseAmount(purchaseAmount)) {
            return;
        }
        throw new IllegalArgumentException(String.format("구입금액은 %d 이상만 허용됩니다.", PRICE_OF_LOTTO));
    }

    private boolean isValidRangeOfPurchaseAmount(long purchaseAmount) {
        return PRICE_OF_LOTTO <= purchaseAmount;
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }
}
