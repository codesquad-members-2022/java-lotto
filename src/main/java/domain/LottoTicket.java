package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> list;

    public LottoTicket(ArrayList<LottoNumber> list) {
        if (!isValidTicketSize(list)) {
            throw new IllegalArgumentException("로또 숫자는 6개가 필요합니다.");
        }
        this.list = list;
        Collections.sort(list);
    }

    public int size() {
        return list.size();
    }

    private boolean isValidTicketSize(ArrayList<LottoNumber> list) {
        return list.size() == 6;
    }

    public int countWinningNumber(int[] winningNumbers) {
        int count = 0;
        for (LottoNumber lottoNumber : list) {
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
        System.out.println(list);
    }

    public boolean checkBonusNumber(int bonusNumber) {
        for (LottoNumber lottoNumber : list) {
            if (lottoNumber.isSameNumber(bonusNumber)) {
                return true;
            }
        }
        return false;
    }
}
