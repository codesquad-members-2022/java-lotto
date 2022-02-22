package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<LottoNumber> list;

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

    private boolean isValidTicketSize(List<LottoNumber> list) {
        return list.size() == 6;
    }

    public int countWinningNumber(List<LottoNumber> winningTicket) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += checkWinningNumber(winningNumbers, list.get(i));
        }
        return count;
    }

    private int checkWinningNumber(List<LottoNumber> winningTicket, LottoNumber myNumber) {
        for (int i = 0; i < winningTicket.size(); i++) {
            if (myNumber.isSameNumber(winningTicket.get(i))) {
                return 1;
            }
        }
        return 0;
    }
}
