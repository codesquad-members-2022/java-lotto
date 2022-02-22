package PACKAGE_NAME.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    private int money;
    private List<Integer> winningNumber = new ArrayList<>();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;

    private static final String INPUTMONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public int inputMoney() {
        try {
            System.out.println(INPUTMONEY_MESSAGE);
            money = Integer.parseInt(br.readLine());
            validateMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 금액을 입력해주세요.");
            return inputMoney();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return money;
    }

    public static void main(String[] args){
        InputView inputView = new InputView();
        System.out.println(inputView.inputMoney());

    }



    private void validateMoney(int money) {
        if (money < 1000 || (money % 1000 != 0)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> inputWinningNumber() {
        try {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                winningNumber.add(Integer.parseInt(st.nextToken()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return winningNumber;
    }

}
