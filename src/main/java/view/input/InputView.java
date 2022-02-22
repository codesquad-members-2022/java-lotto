package view.input;

import domain.Money;
import domain.lotto.LottoNumber;
import domain.lotto.WinningTicket;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private static final String REQUEST_INPUT_MONEY_MESSAGE = "구매금액을 입력해주세요.\nMoney > ";
    private static final String REQUEST_INPUT_WINNING_TICKET_MESSAGE = "당첨 번호를 입력해주세요.\nWinning Ticket > ";
    private static final Scanner scanner = new Scanner(System.in);

    public static void close() {
        scanner.close();
    }

    public static Money inputMoney() {
        System.out.print(REQUEST_INPUT_MONEY_MESSAGE);
        int inputMoney = Integer.parseInt(scanner.nextLine());
        return new Money(inputMoney);
    }

    public static WinningTicket inputWinnigTicket() {
        System.out.print(REQUEST_INPUT_WINNING_TICKET_MESSAGE);
        String[] inputSplit = scanner.nextLine().split(",");
        Set<LottoNumber> lottoNumbers = parseLottoNumbers(inputSplit);
        return new WinningTicket(lottoNumbers);
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
