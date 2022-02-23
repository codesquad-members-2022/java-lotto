package controller;

import domain.LottoTicket;
import domain.LottoTicketSeller;
import domain.Person;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {

    public void run() {
        int userMoney = InputView.requestMoney();
        LottoTicketSeller seller = new LottoTicketSeller();

        Person testUser = new Person("testUser", userMoney, seller);
        testUser.buyRandomLottoTicket(userMoney);

        showLottoInfo(testUser);

        showResult(makeResult(testUser));
    }

    private int[] makeResult(Person testUser) {
        String[] winningNumbers = getWinningNumbersWithBonusNumber();
        return testUser.checkLottoTickets(Arrays.stream(winningNumbers).mapToInt(Integer::parseInt).toArray());
    }

    private String[] getWinningNumbersWithBonusNumber() {
        String[] winningNumbers = InputView.requestLottoWinningNumbers();
        String bonusNumber = InputView.requestBonusNumber();
        String[] temp = new String[7];
        System.arraycopy(winningNumbers, 0, temp, 0, winningNumbers.length);
        temp[6] = bonusNumber;
        return temp;
    }

    private void showResult(int[] results) {
        OutputView.readResult(results);
        OutputView.showResult();
        OutputView.showStatistics();
    }

    private void showLottoInfo(Person user) {
        List<LottoTicket> ticketList = user.getMyLottoTicketList();
        for (LottoTicket lottoTicket : ticketList) {
            lottoTicket.showLottoNumbers();
        }
    }
}
