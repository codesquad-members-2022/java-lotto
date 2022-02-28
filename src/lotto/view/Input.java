package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.validate.Validator;

public class Input {

    public static final String WINNING_NUMBERS_INFO = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_LOTTO_NUMBERS_INFO = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String REQUEST_MONET_INFO = "구입금액을 입력해 주세요.";
    private static final String BONUS_NUMBER_INFO = "보너스 번호를 입력해주세요.";
    private static final String REQUEST_NUMBER_OF_LOTTO_INFO = "수동으로 구매할 로또 수를 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public int getInputMoney() {
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

    public int getBonusNumber() {
        System.out.println(BONUS_NUMBER_INFO);
        try {
            return Validator.validateStringToInteger(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    public List<LottoNumber> getLottoNumbers(String message) throws IllegalArgumentException {
        System.out.println(message);
        return Arrays.stream(scanner.nextLine().split(",")).map(String::trim)
            .mapToInt(Integer::parseInt)
            .sorted()
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public int getInputNumbOfLottos(int inputMoney) {
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
