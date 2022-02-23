package app.lotto.view;

import app.lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static app.lotto.validation.InputViewValidator.*;

public class InputView {

    private static final int LOTTERY_NUMBER_COUNT = 6;
    private static final int LOTTERY_NUMBER_MIN = 1;
    private static final int LOTTERY_NUMBER_MAX = 45;
    private static final int PRICE_OF_LOTTERY = 1000;

    private static final Scanner sc = new Scanner(System.in);

    public static int readAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = Integer.parseInt(sc.nextLine());
            validateAmountUnit(amount, PRICE_OF_LOTTERY);
            System.out.println();
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAmount();
        }
    }

    public static int readCustomLottoCount(int totalCount) {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            int count = Integer.parseInt(sc.nextLine());
            validateRange(0, totalCount, count);
            System.out.println();
            return count;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAmount();
        }
    }

    public static List<LottoTicket> readCustomLottoNumbers(int count) {
        List<LottoTicket> customLottoNumbers = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        while (customLottoNumbers.size() < count) {
            LottoTicket lottoNumbers = readLottoNumbers();
            customLottoNumbers.add(lottoNumbers);
        }
        System.out.println();
        return customLottoNumbers;
    }

    public static LottoTicket readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLottoNumbers();
    }

    private static LottoTicket readLottoNumbers() {
        try {
            String[] input = sc.nextLine().split(",");
            validateNumbersCount(input, LOTTERY_NUMBER_COUNT);

//            LottoTicket lottoNumbers = getLottoTicket(input);
            LottoTicket lottoNumbers = LottoTicket.createWithStringNumbers(input);

            validateNumbersRange(lottoNumbers, LOTTERY_NUMBER_MIN, LOTTERY_NUMBER_MAX);
            return lottoNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLottoNumbers();
        }
    }

    public static int readBonusNumber() {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            int bonusNumber = Integer.parseInt(sc.nextLine());
            validateRange(LOTTERY_NUMBER_MIN, LOTTERY_NUMBER_MAX, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber();
        }
    }

    private static LottoTicket getLottoTicket(String[] input) {
        return new LottoTicket(Arrays.stream(input)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
    }
}
