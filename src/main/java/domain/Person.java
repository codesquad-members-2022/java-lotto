package domain;

import domain.factory.CustomTicketFactory;
import domain.factory.RandomTicketFactory;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private static final int TICKET_PRICE = 1000;
    private static final int SECOND_WINNING_COUNT = 5;
    private static final int SECOND_WITH_BONUS_WINNING_COUNT = 7;
    private static final int NUMBER_OF_RANKS = 8;

    private final LottoTicketSeller lottoTicketSeller;
    private int money;
    private final List<LottoTicket> myLottoTicketList;

    public Person(int money, LottoTicketSeller lottoTicketSeller) {
        this.money = money;
        this.lottoTicketSeller = lottoTicketSeller;
        myLottoTicketList = new ArrayList<>();
    }

    public void buyRandomLottoTicket(int money) {
        lottoTicketSeller.setFactory(new RandomTicketFactory());
        isValidInputMoney(money);
        int ticketCount = money / TICKET_PRICE;
        for (int i = 0; i < ticketCount; i++) {
            myLottoTicketList.add(lottoTicketSeller.exchangeTicket(new ArrayList<>()));
        }
        this.money -= money;
    }

    public void buyCustomLottoTicket(int[] numbers) {
        lottoTicketSeller.setFactory(new CustomTicketFactory());
        ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        myLottoTicketList.add(lottoTicketSeller.exchangeTicket(lottoNumbers));
        this.money -= TICKET_PRICE;
    }

    private void isValidInputMoney(int money) {
        if (!isValidRestMoney(money)) {
            throw new IllegalArgumentException("남은 잔액은 " + this.money + "입니다.");
        }
        if (!isValidMinimumMoney(money)) {
            throw new IllegalArgumentException("지불 해주셔야 하는 최소 금액은 1000원 입니다.");
        }
    }

    private boolean isValidMinimumMoney(int money) {
        return money >= TICKET_PRICE;
    }

    private boolean isValidRestMoney(int money) {
        return this.money - money >= 0;
    }

    public int getBoughtTicketNumber() {
        return myLottoTicketList.size();
    }

    public int getRestMoney() {
        return money;
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
