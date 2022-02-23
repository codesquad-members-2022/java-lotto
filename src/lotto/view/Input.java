package lotto.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String REQUEST_MONET_INFO = "구입금액을 입력해 주세요.";
    private static final String LUCKY_NUMBERS_INFO = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INFO = "보너스 번호를 입력해주세요.";
    private static final String REQUEST_LOTTO_NUMBER_INFO = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String REQUEST_LOTTO_NUMBERS_INFO = "수동으로 구매할 번호를 입력해 주세요.";
    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBERS_LENGTH = "로또 번호는 6개를 입력해주세요.";
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBER_RANGE = "로또번호는 1~45 범위의 숫자로 입력해주세요.";
    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBER_DUPLICATION = "로또번호는 서로 다른 숫자로 입력해주세요.";

    private Input() {
    }

    public static int getInputMoney() {
        System.out.println(REQUEST_MONET_INFO);
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_INFO);
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

    public static int[] getLuckyNumbers() {
        System.out.println(LUCKY_NUMBERS_INFO);
        return trimInputLuckyNumbers();
    }

    private static int[] trimInputLuckyNumbers() {
        String[] split = scanner.nextLine().split(",");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i].trim());
        }
        return result;
    }

    public static int getInputNumbOfLottos() {
        System.out.println(REQUEST_LOTTO_NUMBER_INFO);
        int numOfLotto = scanner.nextInt();
        scanner.nextLine();
        return numOfLotto;
    }

    public static void getLottoNumbersInfo() {
        System.out.println(REQUEST_LOTTO_NUMBERS_INFO);

    }

    public static List<Integer> getLottoNumbers() throws IllegalArgumentException {
        List<Integer> lottoNumbers = Arrays.stream(scanner.nextLine().split(",")).map(String::trim)
            .mapToInt(Integer::parseInt)
            .sorted()
            .boxed()
            .collect(Collectors.toList());

        isValidLottoNumbers(lottoNumbers);

        return lottoNumbers;
    }

    private static void isValidLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBERS_LENGTH);
        }
        boolean isNotValidRangeLottoNumber = lottoNumbers.stream()
            .anyMatch((number) -> (number < MIN_VALUE || number > MAX_VALUE));
        if (isNotValidRangeLottoNumber) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBER_RANGE);
        }
        Set<Integer> abcd = new HashSet<>(lottoNumbers);
        if (abcd.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBER_DUPLICATION);
        }
    }
}
