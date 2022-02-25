package app.lotto.domain;

import app.lotto.view.InputView;
import app.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoCashier {

    private final LottoTicketManager lottoTicketManager;

    private int amount;
    private int customLottoCount;

    private LottoCashier() {
        receiveOrder();
        this.lottoTicketManager = LottoTicketManager.createWithTotalAmountAndCustomTicketCount(amount, customLottoCount);
    }

    private void receiveOrder() {
        this.amount = InputView.readAmount();
        this.customLottoCount = InputView.readCustomLottoCount(LottoAutoMachine.getLottoCount(amount));
    }

    public static LottoCashier receiveOrderAndCreate() {
        return new LottoCashier();
    }

    public int getAmount() {
        return amount;
    }

    public void showAllLottoTickets() {
        OutputView.printLottoCount(lottoTicketManager.getCustomTicketCount(), lottoTicketManager.getAutoTicketCount());
        OutputView.printAllLottoNumbers(lottoTicketManager.getCustomLottoTickets());
        OutputView.printAllLottoNumbers(lottoTicketManager.getAutoLottoTickets());
        System.out.println();
    }

    public List<LottoTicket> getAllLottoTickets() {
        List<LottoTicket> allLottoTickets = new ArrayList<>();
        allLottoTickets.addAll(lottoTicketManager.getCustomLottoTickets());
        allLottoTickets.addAll(lottoTicketManager.getAutoLottoTickets());

        return allLottoTickets;
    }
}
