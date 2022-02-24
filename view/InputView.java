package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.LottoCompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class InputView {
    private int money;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;

    private static final LottoCompany lottoCompany = new LottoCompany();

    private static final String INPUTMONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUTNUMBER_MESSAGE = "당첨번호를 입력해 주세요.";
    private static final String INVALID_NUMBERS = "올바른 번호를 입력해 주세요.";
    private static final String INVALID_MONEY = "올바른 번호를 입력해 주세요.";
    private static final String DELIMETER_COMMA = ",";
    private static final int ZERO = 0;
    private static final int VALID_LOTTO_COUNT = 6;
    private static final int MINIMUM_MONEY = 1000;

    public int inputMoney() {
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

        try {
            System.out.println(INPUTNUMBER_MESSAGE);
            String inputWinningNumber = br.readLine();
            winningNumber = Arrays.stream(inputWinningNumber.split(DELIMETER_COMMA))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
            validateNumbers(winningNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_NUMBERS);
            inputWinningNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return winningNumber;
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
}
