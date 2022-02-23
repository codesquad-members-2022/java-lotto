package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    public static final int TICKET_PRICE = 1000;
    private final String name;
    private final LottoTicketSeller lottoTicketSeller;
    private int money;
    private List<LottoTicket> myLottoTicketList;

    public Person(String name, int money, LottoTicketSeller lottoTicketSeller) {
        this.name = name;
        this.money = money;
        this.lottoTicketSeller = lottoTicketSeller;
        myLottoTicketList = new ArrayList<>();
    }

    public void buyRandomLottoTicket(int money) {
        isValidInputMoney(money);
        myLottoTicketList = lottoTicketSeller.exchangeTicket(money);
        this.money -= money;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void buyCustomLottoTicket(int[] numbers) {
        ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        myLottoTicketList.add(lottoTicketSeller.exchangeTicket(lottoNumbers));
        this.money -= TICKET_PRICE;
    }

    public int[] checkLottoTickets(int[] numbers) {
        int[] result = new int[8];
        for (LottoTicket lottoTicket : myLottoTicketList) {
            int count = lottoTicket.countWinningNumber(numbers);
            if (count == 5 && lottoTicket.checkBonusNumber(numbers[6])) {
                result[7]++;
                continue;
            }
            result[count]++;
        }
        return result;
    }

    public List<LottoTicket> getMyLottoTicketList() {
        return myLottoTicketList;
    }
}
