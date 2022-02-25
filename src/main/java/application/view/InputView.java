package application.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Deprecated
public class InputView {

    private static InputView inputView;

    private final Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public int getMoney() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String line = scanner.nextLine();
        InputValidator.validateNumberFormat(line);
        return Integer.parseInt(line);
    }

    public List<Integer> getWinningNumbers() throws IllegalArgumentException {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] split = scanner.nextLine().trim().split(",");

        return Arrays.stream(split)
                .filter(InputValidator::validateNumberFormat)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        String line = scanner.nextLine();
        InputValidator.validateNumberFormat(line);
        return Integer.parseInt(line);
    }

    public int getManualCount(int money) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        String line = scanner.nextLine();
        InputValidator.validateNumberFormat(line);

        int manualCount = Integer.parseInt(line);
        InputValidator.validateManualCount(money, manualCount);
        return manualCount;
    }

    public void requestManual() {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    }

    public List<Integer> getManualNumbers() throws IllegalArgumentException {
        String line = scanner.nextLine();
        String[] split = line.trim().split(",");

        return Arrays.stream(split)
                .filter(InputValidator::validateNumberFormat)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
