package lotto_game.view;

import java.util.Scanner;

public class InputView {
    private Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요. ");
        return sc.nextInt();
    }

    public String inputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. ");
        return sc.nextLine();
    }

    public void removeBlank() {
        sc.nextLine();
    }

    public void close() {
        this.sc.close();
    }
}
