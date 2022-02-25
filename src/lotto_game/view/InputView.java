package lotto_game.view;

import lotto_game.exception.MyException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static Scanner sc = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요. ");
        return sc.nextInt();
    }

    public static int inputCountOfManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요. ");
        return sc.nextInt();
    }

    public static List<Integer> inputManualLottoNumbers() {
        String[] manualNumbers = sc.nextLine().split(", ");
        MyException.sixMoreThanManualNumber(manualNumbers);
        return Arrays.stream(manualNumbers)
                .mapToInt(Integer::parseInt)
                .filter(i -> MyException.numberException(i))
                .boxed()
                .collect(Collectors.toList());
    }

    public static void messageManualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요. ");
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
