package app.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static app.lotto.validation.InputViewValidator.*;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public int readAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = Integer.parseInt(sc.nextLine());
            validateAmountUnit(amount, 1000);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAmount();
        }
    }

    public List<Integer> readWinningNumbers() {
        try {
            // 정상값 반환
            System.out.println("당첨 번호를 입력해 주세요.");
            String[] input = sc.nextLine().split(",");

            // 6개 숫자가 들어있는지
            validateNumbersCount(input, 6);
            List<Integer> winningNumbers = Arrays.stream(input)
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            // 1 ~ 45 검증
            validateNumbersRange(winningNumbers, 1, 45);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            // 오류메세지 출력
            System.out.println(e.getMessage());
            return readWinningNumbers();
        }
    }
}
