package application.model;

import java.util.regex.Pattern;

public class Validation {

    private static final int LOTTO_TICKET_PRICE = 1000;

    // 2. ',' , ' ', '숫자' 외 다른 문자가 들어오는 경우 [정규식]
    // 3. 수동으로 구매하려는 로또의 개수가 구매금액을 초과하거나 음수인 경우
    // 4. 보너스볼의 입력범위가 1 ~ 45가 아닌 경우, winningNumbers랑 겹치는 경우

    public boolean validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_TICKET_PRICE) {
            return false;
        }
        return true;
    }

    public boolean validateGetManualLotto(String manualLottoString) {
        String pattern = "^[0-9]\\,\\s[0-9]\\,\\s[0-9]\\,\\s[0-9]\\,\\s[0-9]\\,\\s[0-9]";
        if (Pattern.matches(pattern, manualLottoString)) {
            return true;
        }
        return false;
    }
}
