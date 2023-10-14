package domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private static final int SECOND_WINNING_COUNT = 5;
    private static final int SECOND_WITH_BONUS_WINNING_COUNT = 7;
    private static final int NUMBER_OF_RANKS = 8;

    private final List<LottoTicket> myLottoTicketList;

    public Person() {
        myLottoTicketList = new ArrayList<>();
    }

    public void buyRandomLottoTicket(LottoTicket lottoTicket) {
        myLottoTicketList.add(lottoTicket);
    }

    public void buyCustomLottoTicket(LottoTicket lottoTicket) {
        myLottoTicketList.add(lottoTicket);
    }

    public List<LottoTicket> getMyLottoTicketList() {
        return myLottoTicketList;
    }

    public int[] checkLottoTickets(WinningNumbers winningNumbers) {
        int[] result = new int[NUMBER_OF_RANKS];
        for (LottoTicket lottoTicket : myLottoTicketList) {
            checkThisTicket(winningNumbers, result, lottoTicket);
        }
        return result;
    }

    private void checkThisTicket(WinningNumbers winningNumbers, int[] result, LottoTicket lottoTicket) {
        int count = lottoTicket.countWinningNumber(winningNumbers);
        if (count == SECOND_WINNING_COUNT && lottoTicket.checkBonusNumber(winningNumbers.getBonusNumber())) {
            result[SECOND_WITH_BONUS_WINNING_COUNT]++;
            return;
        }
        result[count]++;
    }
}
