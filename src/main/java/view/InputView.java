package view;

import java.util.Scanner;

public class InputView {
    private final static Scanner sc = new Scanner(System.in);

    public static int getAmount() {
        System.out.println("구매 금액을 입력해 주세요.");

        return sc.nextInt();
    }
}
