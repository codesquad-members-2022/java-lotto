package domain.lotto;

public class Money {

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
        throw new IllegalArgumentException(String.format("구입금액은 %d의 배수만 가능합니다.", LottoTicket.LOTTO_TICKET_PRICE));
    }

    private boolean isMultipleOfPrice(long purchaseAmount) {
        return purchaseAmount % 1000 == 0;
    }

    private void validateRangeOfPurchaseAmount(long purchaseAmount) {
        if (isValidRangeOfPurchaseAmount(purchaseAmount)) {
            return;
        }
        throw new IllegalArgumentException(String.format("구입금액은 %d 이상만 허용됩니다.", LottoTicket.LOTTO_TICKET_PRICE));
    }

    private boolean isValidRangeOfPurchaseAmount(long purchaseAmount) {
        return LottoTicket.LOTTO_TICKET_PRICE <= purchaseAmount;
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public long numberOfBuyableLottoTickets() {
        return purchaseAmount / LottoTicket.LOTTO_TICKET_PRICE;
    }
}
