package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int NORMAL_TICKET_SIZE = 6;
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 숫자는 6개가 필요합니다.";
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        if (!isValidTicketSize(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
        this.lottoNumbers = lottoNumbers;
        Collections.sort(this.lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }

    private boolean isValidTicketSize(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() == NORMAL_TICKET_SIZE;
    }

    public int countWinningNumber(WinningNumbers winningNumbers) {
        return lottoNumbers.stream()
                .mapToInt(lottoNumber -> checkWinningNumber(winningNumbers, lottoNumber))
                .sum();
    }

    private int checkWinningNumber(WinningNumbers winningNumbers, LottoNumber myNumber) {
        return (int) IntStream.range(0, winningNumbers.getSize())
                .filter(i -> check(winningNumbers.getNumberOfIndex(i), myNumber))
                .count();
    }

    private boolean check(LottoNumber numberOfIndex, LottoNumber myNumber) {
        return myNumber.equals(numberOfIndex);
    }

    public void showLottoNumbers() {
        System.out.println(lottoNumbers);
    }

    public boolean checkBonusNumber(LottoNumber bonusNumber) {
        return lottoNumbers.stream().anyMatch(i -> matchBonusNumber(bonusNumber, i));
    }

    private boolean matchBonusNumber(LottoNumber bonusNumber, LottoNumber lottoNumber) {
        return lottoNumber.equals(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
