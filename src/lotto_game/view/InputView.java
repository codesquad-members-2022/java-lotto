package lotto_game.view;

import java.util.Scanner;

public class InputView {
    public static Scanner sc = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요. ");
        return sc.nextInt();
    }

    public static String inputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. ");
        return sc.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요. ");
        return sc.nextInt();
    }

    public static void removeBlank() {
        sc.nextLine();
    }

    public static void close() {
        sc.close();
    }
}
