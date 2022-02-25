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
    public static final String NOT_ENOUGH_MONEY_MESSAGE = "돈이 부족합니다.";

    public void run() {
        Person customer = new Person();
        int userMoney = InputView.requestMoney();
        int customTicketCount = InputView.requestCustomTicketCount();

        validateEnoughMoney(userMoney, customTicketCount);

        buyManualLottery(customer, customTicketCount);
        buyRandomLottoTicket(customer, discharge(userMoney, customTicketCount));

        showLottoInfo(customer);

        showResult(makeResult(customer));
        InputView.close();
    }

    private void validateEnoughMoney(int userMoney, int ticketCount) {
        if (userMoney < ticketCount * TICKET_PRICE) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_MESSAGE);
        }
    }

    private int discharge(int userMoney, int customTicketCount) {
        return userMoney - customTicketCount * TICKET_PRICE;
    }

    private void buyRandomLottoTicket(Person customer, int money) {
        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(new RandomTicketFactory());

        int ticketCount = money / TICKET_PRICE;

        for (int i = 0; i < ticketCount; i++) {
            customer.buyRandomLottoTicket(lottoTicketSeller.exchangeTicket(new ArrayList<>()));
        }
    }

    private void buyManualLottery(Person customer, int customTicketCount) {
        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(new CustomTicketFactory());

        InputView.requestCustomTicketNumberMessage();

        for (int i = 0; i < customTicketCount; i++) {
            customer.buyCustomLottoTicket(lottoTicketSeller.exchangeTicket(getLottoNumbers()));
        }
    }

    private ArrayList<LottoNumber> getLottoNumbers() {
        int[] numbers = InputView.requestCustomTicketNumber();
        ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
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
