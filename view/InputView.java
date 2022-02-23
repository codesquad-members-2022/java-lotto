package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.LottoCompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class InputView {
    private int money;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;

    private static final LottoCompany lottoCompany = new LottoCompany();

    private static final String INPUTMONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUTNUMBER_MESSAGE = "당첨번호를 입력해 주세요.";
    private static final String INVALID_NUMBERS = "올바른 번호를 입력해 주세요.";
    private static final String INVALID_MONEY = "올바른 번호를 입력해 주세요.";

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
        if (money < 1000 || (money % 1000 != 0)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> inputWinningNumber() {

        List<Integer> winningNumber = new ArrayList<>();

        try {
            System.out.println(INPUTNUMBER_MESSAGE);
            String inputWinningNumber = br.readLine();
            winningNumber = Arrays.stream(inputWinningNumber.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());
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

    private void validateNumbers(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> set = new HashSet<>(winningNumber);
        if (set.size() != winningNumber.size()) {
            throw new IllegalArgumentException();
        }
    }
}
