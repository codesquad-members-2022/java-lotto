package controller;

import domain.lotto.LottoTickets;
import domain.lotto.Money;
import domain.lotto.RewardMachine;
import domain.lotto.WinningTicket;
import view.input.InputView;
import view.output.OutputView;

public class LottoController {

    public LottoController() {
    }

    public void run() {
        Money money = InputView.inputMoney();
        LottoTickets lottoTickets = LottoTickets.createRandomTickets(money);
        OutputView.printLottoTickets(lottoTickets);

        WinningTicket winningTicket = InputView.inputWinnigTicket();
        RewardMachine rewardMachine = new RewardMachine(money, lottoTickets, winningTicket);

        OutputView.printReward(rewardMachine);
        InputView.close();
    }

}
