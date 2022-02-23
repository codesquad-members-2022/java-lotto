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

    public static boolean askIsAuto() {
        sc = new Scanner(System.in);
        System.out.println("자동을 원하시면 'a', 수동을 원하시면 'm'을 입력해주세요.");
        char input = sc.nextLine().charAt(0);
        while (input != 'a' && input != 'm') {
            System.out.println("올바르지 않은 명령입니다. 'a'와 'm'으로 입력하세요.");
            input = sc.nextLine().charAt(0);
        }
        return Objects.equals(input, 'a');
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

    public static int getBonusNumber(){
        sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }
}
