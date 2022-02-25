package controller;

import domain.*;
import domain.factory.CustomTicketFactory;
import domain.factory.RandomTicketFactory;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static final int TICKET_PRICE = 1000;

    public void run() {
        int userMoney = InputView.requestMoney();
        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(new RandomTicketFactory());
        Person customer = new Person();
        int customTicketCount = buyManualLottery(customer, new LottoTicketSeller(new CustomTicketFactory()));

        buyRandomLottoTicket(customer, lottoTicketSeller, discharge(userMoney, customTicketCount));

        showLottoInfo(customer);

        showResult(makeResult(customer));
        InputView.close();
    }

    private int discharge(int userMoney, int customTicketCount) {
        return userMoney - customTicketCount * TICKET_PRICE;
    }

    private void buyRandomLottoTicket(Person customer, LottoTicketSeller lottoTicketSeller, int money) {
        lottoTicketSeller.setFactory(new RandomTicketFactory());
        int ticketCount = money / TICKET_PRICE;
        for (int i = 0; i < ticketCount; i++) {
            customer.buyRandomLottoTicket(lottoTicketSeller.exchangeTicket(new ArrayList<>()));
        }
    }

    private int buyManualLottery(Person customer, LottoTicketSeller lottoTicketSeller) {
        lottoTicketSeller.setFactory(new CustomTicketFactory());
        int customTicketCount = InputView.requestCustomTicketCount();
        InputView.requestCustomTicketNumberMessage();

        for (int i = 0; i < customTicketCount; i++) {
            int[] numbers = InputView.requestCustomTicketNumber();
            ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();
            for (int number : numbers) {
                lottoNumbers.add(new LottoNumber(number));
            }
            customer.buyCustomLottoTicket(lottoTicketSeller.exchangeTicket(lottoNumbers));
        }
        return customTicketCount;
    }

    private int[] makeResult(Person customer) {
        WinningNumbers winningNumbers = getWinningNumbersWithBonusNumber();
        return customer.checkLottoTickets(winningNumbers);
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

    private void showLottoInfo(Person customer) {
        List<LottoTicket> ticketList = customer.getMyLottoTicketList();
        for (LottoTicket lottoTicket : ticketList) {
            lottoTicket.showLottoNumbers();
        }
    }
}
