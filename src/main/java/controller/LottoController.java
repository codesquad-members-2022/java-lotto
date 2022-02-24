package controller;

import domain.LottoTicket;
import domain.LottoTicketSeller;
import domain.Person;
import domain.factory.RandomTicketFactory;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {

    private static final int WINNING_NUMBER_SIZE = 7;
    private static final int BONUS_NUMBER_INDEX = 6;

    public void run() {
        int userMoney = InputView.requestMoney();
        LottoTicketSeller seller = new LottoTicketSeller(new RandomTicketFactory());

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
        String[] winningNumbersWithBonus = arrayCopy(winningNumbers);
        winningNumbersWithBonus[BONUS_NUMBER_INDEX] = bonusNumber;
        return winningNumbersWithBonus;
    }

    private String[] arrayCopy(String[] winningNumbers) {
        String[] temp = new String[WINNING_NUMBER_SIZE];
        System.arraycopy(winningNumbers, 0, temp, 0, winningNumbers.length);
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
