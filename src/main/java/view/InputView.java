package view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner sc;

    public static int getAmount() {
        sc = new Scanner(System.in);
        System.out.println("구매 금액을 입력해 주세요.");

        return sc.nextInt();
    }


    public static List<Integer> getWinningNumber() {
        sc = new Scanner(System.in);
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumbers = sc.nextLine().split(",");
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int getNumberOfManualTicket() {
        sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static List<Integer> getManualNumber() {
        List<Integer> manualNumber = new ArrayList<>();
        sc = new Scanner(System.in);
        String[] userInput = sc.nextLine().split(",");
        for (String number : userInput)
            manualNumber.add(Integer.parseInt(number));
        return manualNumber;
    }

    public static int getBonusNumber(){
        sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }
}
