package controller;

import domain.LottoTicketSeller;
import domain.Person;
import view.InputView;

import java.util.Arrays;

public class LottoController {

    public void run() {
        int userMoney = InputView.requestMoney();
        LottoTicketSeller seller = new LottoTicketSeller();
        
        Person testUser = new Person("testUser", userMoney, seller);
        testUser.buyRandomLottoTicket(userMoney);

        String[] numbers = InputView.requestLottoNumbers();
        int[] winningNumbers = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        int[] results = testUser.checkLottoTickets(winningNumbers);

        for (int result : results) {
            System.out.print(result + ", ");
        }
        System.out.println();
    }
}
