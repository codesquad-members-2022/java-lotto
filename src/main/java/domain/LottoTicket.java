package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private static final int NORMAL_TICKET_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(ArrayList<LottoNumber> lottoNumbers) {
        if (!isValidTicketSize(lottoNumbers)) {
            throw new IllegalArgumentException("로또 숫자는 6개가 필요합니다.");
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

    public int countWinningNumber(int[] winningNumbers) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            count += checkWinningNumber(winningNumbers, lottoNumber);
        }
        return count;
    }

    private int checkWinningNumber(int[] winningNumbers, LottoNumber myNumber) {
        for (int i = 0; i < winningNumbers.length - 1; i++) {
            if (myNumber.isSameNumber(winningNumbers[i])) {
                return 1;
            }
        }
        return 0;
    }

    public void showLottoNumbers() {
        System.out.println(lottoNumbers);
    }

    public boolean checkBonusNumber(int bonusNumber) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (lottoNumber.isSameNumber(bonusNumber)) {
                return true;
            }
        }
        return false;
    }
}
