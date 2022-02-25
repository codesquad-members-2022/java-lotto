package controller;

import domain.LottoTicket;
import domain.LottoTicketSeller;
import domain.Person;
import domain.WinningNumbers;
import domain.factory.RandomTicketFactory;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {
    private static final int TICKET_PRICE = 1000;

    public void run() {
        int userMoney = InputView.requestMoney();
        LottoTicketSeller seller = new LottoTicketSeller(new RandomTicketFactory());
        Person testUser = new Person(userMoney, seller);
        int customTicketCount = buyManualLottery(testUser);

        testUser.buyRandomLottoTicket(discharge(userMoney, customTicketCount));

        showLottoInfo(testUser);

        showResult(makeResult(testUser));
        InputView.close();
    }

    private int discharge(int userMoney, int customTicketCount) {
        return userMoney - customTicketCount * TICKET_PRICE;
    }

    private int buyManualLottery(Person testUser) {
        int customTicketCount = InputView.requestCustomTicketCount();
        InputView.requestCustomTicketNumberMessage();
        for (int i = 0; i < customTicketCount; i++) {
            testUser.buyCustomLottoTicket(InputView.requestCustomTicketNumber());
        }
        return customTicketCount;
    }

    private int[] makeResult(Person testUser) {
        WinningNumbers winningNumbers = getWinningNumbersWithBonusNumber();
        return testUser.checkLottoTickets(winningNumbers);
    }

    private WinningNumbers getWinningNumbersWithBonusNumber() {
        String[] winningNumbers = InputView.requestLottoWinningNumbers();
        String bonusNumber = InputView.requestBonusNumber();
        return new WinningNumbers(winningNumbers, bonusNumber);
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
