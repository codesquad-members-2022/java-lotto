package PACKAGE_NAME.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUTMONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUTNUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.\nex) 1, 2, 3, 4, 5, 6";
    private static final String INVALID_NUMBERS = "올바른 번호를 입력해 주세요.";
    private static final String INVALID_MONEY = "올바른 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.\n7";
    private static final String DELIMETER_COMMA = ",";
    private static final int ZERO = 0;
    private static final int VALID_LOTTO_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MINIMUM_MONEY = 1000;

    public int inputMoney() {
        int money = Integer.MAX_VALUE;
        try {
            System.out.println(INPUTMONEY_MESSAGE);
            money = Integer.parseInt(br.readLine());
            validateMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_MONEY);
            return inputMoney();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return money;
    }

    private void validateMoney(int money) {
        if (money < MINIMUM_MONEY || (money % MINIMUM_MONEY != ZERO)) {
            throw new IllegalArgumentException();
        }
    }

    public Set<Integer> inputWinningNumber() {
        Set<Integer> winningNumber = new HashSet<>();
        System.out.println(INPUTNUMBER_MESSAGE);
        String inputWinningNumber;
        try {
            inputWinningNumber = br.readLine();
            winningNumber = getCollect(inputWinningNumber);
            validateNumbers(winningNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_NUMBERS);
            inputWinningNumber();
        } catch (IOException e) {
            System.out.println(INVALID_NUMBERS);
        }
        return winningNumber;
    }

    private Set<Integer> getCollect(String inputWinningNumber) {
        return Arrays.stream(inputWinningNumber.split(DELIMETER_COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    private void validateNumbers(Set<Integer> winningNumber) {
        if (winningNumber.size() != VALID_LOTTO_COUNT) {
            throw new IllegalArgumentException();
        }

        Set<Integer> set = new HashSet<>(winningNumber);
        if (set.size() != winningNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int inputBonusNumber() {
        String bonusNumber = null;
        System.out.println(INPUT_BONUS_NUMBER);
        try {
            bonusNumber = br.readLine();
            validateBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_NUMBERS);
            return inputBonusNumber();
        } catch (IOException e) {
            System.out.println(INVALID_NUMBERS);
        }
        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber) {
        int lottoNumber = Integer.parseInt(bonusNumber);
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
