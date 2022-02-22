package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner sc;

    public static int getAmount() {
        sc = new Scanner(System.in);
        System.out.println("구매 금액을 입력해 주세요.");

        return sc.nextInt();
    }


    public static String[] getWinningNumber() {
        sc = new Scanner(System.in);
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return sc.nextLine().split(",");
    }
}
