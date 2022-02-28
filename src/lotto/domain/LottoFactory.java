package lotto.domain;

public class LottoFactory {

    public static LottoTicket issueLottoTicketWithRandomNumbers() {
        return new LottoTicket(LottoNumberPool.getLottoNumbers());
    }

    public static LottoTicket issueLottoTicketWithSelectNumbers(int[] numbers) {
        return new LottoTicket(new LottoNumbers(numbers));
    }

    public static WinningNumber selectWinningNumber(int[] numbers, int bonusNumber) {
        return new WinningNumber(new LottoNumbers(numbers), new LottoNumber(bonusNumber));
    }

}
