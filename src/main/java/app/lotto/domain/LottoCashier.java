package app.lotto.domain;

import app.lotto.view.InputView;
import app.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoCashier {

    private static final int LOTTO_PRICE = 1000;

    private final LottoTicketManager lottoTicketManager;
    private final int amount;

    private LottoCashier(int amount, int customLottoCount) {
        this.amount = amount;
        this.lottoTicketManager = LottoTicketManager.createWithTotalAmountAndCustomTicketCount(amount, customLottoCount);
    }

    public static LottoCashier receiveOrderAndCreate() {
        int amount = InputView.readAmount();
        int customLottoCount = InputView.readCustomLottoCount(getLottoCount(amount));

        return new LottoCashier(amount, customLottoCount);
    }

    private static int getLottoCount(int amount) {
        return amount / LOTTO_PRICE;
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
