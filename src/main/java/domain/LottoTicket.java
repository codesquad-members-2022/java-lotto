package domain;

import java.util.ArrayList;
import java.util.Collections;

public class LottoTicket {
    private static final int NORMAL_TICKET_SIZE = 6;
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 숫자는 6개가 필요합니다.";
    private final ArrayList<LottoNumber> lottoNumbers;

    public LottoTicket(ArrayList<LottoNumber> lottoNumbers) {
        if (!isValidTicketSize(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
        this.lottoNumbers = lottoNumbers;
        Collections.sort(this.lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }

    private boolean isValidTicketSize(ArrayList<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() == NORMAL_TICKET_SIZE;
    }

    public int countWinningNumber(WinningNumbers winningNumbers) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            count += checkWinningNumber(winningNumbers, lottoNumber);
        }
        return count;
    }

    private int checkWinningNumber(WinningNumbers winningNumbers, LottoNumber myNumber) {
        for (int i = 0; i < winningNumbers.getSize(); i++) {
            if (myNumber.isSameNumber(winningNumbers.getNumberOfIndex(i))) {
                return 1;
            }
        }
        return 0;
    }

    public void showLottoNumbers() {
        System.out.println(lottoNumbers);
    }

    public boolean checkBonusNumber(LottoNumber bonusNumber) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (lottoNumber.isSameNumber(bonusNumber)) {
                return true;
            }
        }
        return false;
    }
}
