package application.model;

import java.util.regex.Pattern;

import application.domain.Lotto;

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
        String pattern = "([1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5])((,(\\s)?)([1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5])){5}(\\s)?$";
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

    public boolean validateBonusBallNumberRange(int bonusBallNumber, Lotto winningNumber) {
        if (bonusBallNumber < 1 || bonusBallNumber > 45 || winningNumber.isContainBonusBallNumber(bonusBallNumber)) {
            return false;
        }
        return true;
    }

}
