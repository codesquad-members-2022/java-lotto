package view.input;

import domain.lotto.*;

import java.util.*;

public class InputView {

    private static final String REQUEST_INPUT_MONEY_MESSAGE = "구매금액을 입력해주세요.\nMoney > ";
    private static final String REQUEST_INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해주세요.\nWinning Numbers > ";
    private static final String REQUEST_INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.\nBonue Number > ";
    private static final String REQUEST_INPUT_MANUAL_LOTTOTICKET_NUMBER_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.\n개수 > ";
    private static final String REQUEST_INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.\n";
    private static final Scanner scanner = new Scanner(System.in);

    public static void close() {
        scanner.close();
    }

    public static Money inputMoney() {
        System.out.print(REQUEST_INPUT_MONEY_MESSAGE);
        int inputMoney = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return new Money(inputMoney);
    }

    public static WinningTicket inputWinningTicket() {
        Set<LottoNumber> lottoNumbers = inputWinnnigNumbers();
        LottoNumber bonusNumber = inputBonusNumber();

        return new WinningTicket(lottoNumbers, bonusNumber);
    }

    private static Set<LottoNumber> inputWinnnigNumbers() {
        System.out.print(REQUEST_INPUT_WINNING_NUMBERS_MESSAGE);
        Set<LottoNumber> winningNumbers = inputLottoNumbers();
        System.out.println();
        return winningNumbers;
    }

    private static Set<LottoNumber> inputLottoNumbers() {
        String[] inputSplit = scanner.nextLine().split(",");
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

    public static int inputCountOfManualLottoTicket(Money money) {
        System.out.print(REQUEST_INPUT_MANUAL_LOTTOTICKET_NUMBER_MESSAGE);
        int inputCountOfManualLottoTicket = Integer.parseInt(scanner.nextLine());
        validatePurchaseCount(inputCountOfManualLottoTicket, money);
        System.out.println();
        return inputCountOfManualLottoTicket;
    }

    private static void validatePurchaseCount(int countOfManualLottoTicket, Money money) {
        long buyableLottoTicketCount = money.numberOfBuyableLottoTickets();
        if (0 <= countOfManualLottoTicket  && countOfManualLottoTicket <= buyableLottoTicketCount) {
            return;
        }
        throw new IllegalArgumentException("유효한 수동 구매 개수가 아닙니다.");
    }

    public static List<LottoTicket> inputManualLottoTickets(int count) {
        return isManualTicketCountZero(count) ? new ArrayList<>() : createManualLottoTickets(count);
    }

    private static List<LottoTicket> createManualLottoTickets(int count) {
        System.out.print(REQUEST_INPUT_MANUAL_LOTTO_NUMBERS);
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i< count; i++) {
            tickets.add(LottoTicket.createManualTicket(inputManualTicket()));
        }
        System.out.println();
        return tickets;
    }

    private static boolean isManualTicketCountZero(int count) {
        return count == 0;
    }

    private static Set<LottoNumber> inputManualTicket() {
        return inputLottoNumbers();
    }
}
