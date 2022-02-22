package controller;

import domain.LottoTicket;
import domain.LottoTicketSeller;
import domain.Person;
import view.InputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {

    public void run() {
        int userMoney = InputView.requestMoney();
        LottoTicketSeller seller = new LottoTicketSeller();
        
        Person testUser = new Person("testUser", userMoney, seller);
        testUser.buyRandomLottoTicket(userMoney);
        showLottoInfo(testUser);

        for (int result : results) {
            System.out.print(result + ", ");
        }
        System.out.println();
    }
}
