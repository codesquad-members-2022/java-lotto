package lotto_game.view;

import java.util.Scanner;

public class InputView {
    private Scanner sc;
    private final static String PRICE = "구입금액을 입력해 주세요. ";
    private final static String WIN = "당첨 번호를 입력해 주세요. ";

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public int inputPrice() {
        System.out.println(PRICE);
        return sc.nextInt();
    }

    public String inputWinNumber() {
        System.out.println(WIN);
        return sc.next();
    }
}
