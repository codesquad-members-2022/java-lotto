package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.validate.Validator;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String REQUEST_MONET_INFO = "구입금액을 입력해 주세요.";
    private static final String LUCKY_NUMBERS_INFO = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INFO = "보너스 번호를 입력해주세요.";
    private static final String REQUEST_NUMBER_OF_LOTTO_INFO = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String REQUEST_LOTTO_NUMBERS_INFO = "수동으로 구매할 번호를 입력해 주세요.";

    private Input() {
    }

    public static int getInputMoney() {
        System.out.println(REQUEST_MONET_INFO);
        int money = scanner.nextInt();
        try {
            Validator.validateMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputMoney();
        }
        scanner.nextLine();
        return money;
    }

    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_INFO);
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

    public static List<Integer> getLottoNumbers() throws IllegalArgumentException {
        System.out.println(REQUEST_LOTTO_NUMBERS_INFO);
        return Arrays.stream(scanner.nextLine().split(",")).map(String::trim)
            .mapToInt(Integer::parseInt)
            .sorted()
            .boxed()
            .collect(Collectors.toList());
    }

    public static List<Integer> getLuckyNumbers() {
        System.out.println(LUCKY_NUMBERS_INFO);
        return getLottoNumbers();
    }

    public static int getInputNumbOfLottos(int inputMoney) {
        System.out.println(REQUEST_NUMBER_OF_LOTTO_INFO);
        int numOfLotto = scanner.nextInt();
        try {
            Validator.validateNumOfLotto(numOfLotto, inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputNumbOfLottos(inputMoney);
        }
        scanner.nextLine();
        return numOfLotto;
    }
}
