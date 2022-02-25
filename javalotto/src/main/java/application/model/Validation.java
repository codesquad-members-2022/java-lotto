package application.model;

import java.util.regex.Pattern;

public class Validation {

    private static final int LOTTO_TICKET_PRICE = 1000;

    // 4. 보너스볼의 입력범위가 1 ~ 45가 아닌 경우, winningNumbers랑 겹치는 경우

    public boolean validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_TICKET_PRICE) {
            return false;
        }
        return true;
    }

    public boolean validateLottoString(String lottoString) {
        String pattern = "^[0-9]\\,\\s[0-9]\\,\\s[0-9]\\,\\s[0-9]\\,\\s[0-9]\\,\\s[0-9]";
        if (Pattern.matches(pattern, lottoString)) {
            return true;
        }
        return false;
    }

    public boolean validateNumberOfManualLotto(int numberOfManualLotto, int money) {
        if (money / LOTTO_TICKET_PRICE < numberOfManualLotto || numberOfManualLotto < 0) {
            return false;
        }
        return true;
    }

}
