package app.lotto.view;

import java.util.Scanner;

public class InputView {

    public int readAmount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int amount = sc.nextInt();
        if (amount % 1000 == 0) {
            return amount;
        }

        System.out.println("1000원 단위로 입력해 주세요.");
        return readAmount();
    }
}
