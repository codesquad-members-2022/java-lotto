package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc;

    public static int getPurchaseAmount() {     
        return sc.nextInt();
    }

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }
}
