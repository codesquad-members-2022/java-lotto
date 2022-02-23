package view.input;

import domain.lotto.Money;
import domain.lotto.LottoNumber;
import domain.lotto.WinningTicket;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private static final String REQUEST_INPUT_MONEY_MESSAGE = "구매금액을 입력해주세요.\nMoney > ";
    private static final String REQUEST_INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해주세요.\nWinning Numbers > ";
    private static final String REQUEST_INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.\nBonue Number > ";
    private static final Scanner scanner = new Scanner(System.in);

    public static void close() {
        scanner.close();
    }

    public static Money inputMoney() {
        System.out.print(REQUEST_INPUT_MONEY_MESSAGE);
        int inputMoney = Integer.parseInt(scanner.nextLine());
        return new Money(inputMoney);
    }

    public static WinningTicket inputWinningTicket() {
        Set<LottoNumber> lottoNumbers = inputWinnnigNumbers();
        LottoNumber bonusNumber = inputBonusNumber();

        return new WinningTicket(lottoNumbers, bonusNumber);
    }

    private static Set<LottoNumber>  inputWinnnigNumbers() {
        System.out.print(REQUEST_INPUT_WINNING_NUMBERS_MESSAGE);
        String[] inputSplit = scanner.nextLine().split(",");
        System.out.println();
        Set<LottoNumber> lottoNumbers = parseLottoNumbers(inputSplit);
        return lottoNumbers;
    }

    private static LottoNumber inputBonusNumber() {
        System.out.print(REQUEST_INPUT_BONUS_NUMBER_MESSAGE);
        int inputBonusNumber = Integer.parseInt(scanner.nextLine());
        System.out.println();

        return LottoNumber.of(inputBonusNumber);
    }

    private static Set<LottoNumber> parseLottoNumbers(String[] inputSplit) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (String s : inputSplit) {
            LottoNumber lottoNumber = LottoNumber.of(Integer.parseInt(s));
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }
}
