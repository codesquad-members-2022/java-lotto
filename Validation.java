import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {

    private static final int LOTTO_EACH_MONEY = 1000;

    public boolean validateMoney(String userInput) {
        try {
            int money = Integer.parseInt(userInput);
            if (money % LOTTO_EACH_MONEY != 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            InputView.informError();
            return false;
        }
        return true;
    }

    public boolean validateCountOfManualLotto(String userInput, int countOfLotto) {
        try {
            int countOfManualLotto = Integer.parseInt(userInput);
            if (countOfManualLotto > countOfLotto || countOfManualLotto < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            InputView.informError();
            return false;
        }

        return true;
    }

    public boolean validateLottoNumber(String userInput) {
        String inputPattern = "([1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5])((,(\s)?)([1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5])){5}(\s)?$";
        if (!Pattern.matches(inputPattern, userInput)) {
            InputView.informError();
            return true;
        }

        return false;
    }

    public boolean validateBonusNumber(String userInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(userInput);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new Exception();
            }
        } catch (Exception e) {
            InputView.informError();
            return false;
        }

        return true;
    }

    public boolean validateRepetition(List<Integer> lottoNumberList) {
        Set<Integer> set = new HashSet<>(lottoNumberList);
        if (set.size() == 6) {
            return false;
        }
        InputView.informError();
        return true;
    }
}
