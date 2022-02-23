package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public static boolean askisAuto() {
        sc = new Scanner(System.in);
        System.out.println("자동을 원하시면 'a', 수동을 원하시면 'm'을 입력해주세요.");
        if (Objects.equals(sc.next(), 'a'))
            return true;
        return false;
    }

    public static List<Integer> getManualNumber() {
        List<Integer> manualNumber = new ArrayList<>();
        sc = new Scanner(System.in);
        System.out.println("응모할 번호 6자리를 입력해 주세요.");
        String[] userInput = sc.nextLine().split(",");
        for (String number : userInput)
            manualNumber.add(Integer.parseInt(number));
        return manualNumber;
    }
}
