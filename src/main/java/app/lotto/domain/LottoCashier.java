package app.lotto.domain;

import app.lotto.view.InputView;
import app.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoCashier {

    private final LottoTicketManager lottoTicketManager;
    private final int amount;

    private LottoCashier(int amount, int customLottoCount) {
        this.amount = amount;
        this.lottoTicketManager = LottoTicketManager.createWithTotalAmountAndCustomTicketCount(amount, customLottoCount);
    }

    public static LottoCashier receiveOrderAndCreate() {
        int amount = InputView.readAmount();
        int customLottoCount = InputView.readCustomLottoCount(LottoAutoMachine.getLottoCount(amount));

        return new LottoCashier(amount, customLottoCount);
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
