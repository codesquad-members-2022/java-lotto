package application.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
}
