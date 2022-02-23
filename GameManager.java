package PACKAGE_NAME;

import PACKAGE_NAME.domain.LottoTickets;
import PACKAGE_NAME.view.InputView;
import PACKAGE_NAME.view.OutputView;

public class GameManager {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoController lottoController = new LottoController();

    public void play() {
        while (true) {
            int money = inputView.inputMoney();
            int ticketCount = money / 1000;

            LottoTickets lottoTickets = lottoController.get(money);
            System.out.println(ticketCount + "개를 구매했습니다.");

            printLottoTickets(lottoTickets);
        }
    }

    private void printLottoTickets(LottoTickets lottoTickets) {
        outputView.printLottoTicket(lottoTickets);
    }

}
