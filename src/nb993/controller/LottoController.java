package nb993.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import nb993.model.LottoTicket;
import nb993.model.Rank;
import nb993.model.WinningNumber;
import nb993.view.PrintView;
import nb993.view.ScanView;

import java.util.List;

public class LottoController {

    public static final int PRICE_PER_LOTTO = 1000;

    private int purchaseCount;
    private int manualPurchaseCount;

    private final ScanView scanView;
    private final PrintView printView;
    private List<LottoTicket> lottos;

    public LottoController(ScanView scanView, PrintView printView) {
        this.scanView = scanView;
        this.printView = printView;
    }

    public void initLottos() {
        this.lottos = new ArrayList<>();
        int purchaseAmount = scanView.getPurchaseAmount();

        purchaseCount = purchaseAmount / PRICE_PER_LOTTO;
        manualPurchaseCount = scanView.getManualPurchaseCount();
        List<List<Integer>> manualTicketList = scanView.getManualNumber(manualPurchaseCount);

        for (int i = 0; i < manualPurchaseCount; i++) {
            lottos.add(new LottoTicket(manualTicketList.get(i)));
        }

        for (int i = 0; i < purchaseCount - manualPurchaseCount; ++i) {
            lottos.add(new LottoTicket());
        }
    }

    public void playGame() {
        initLottos();
        printGame();
        printLottoResult();
    }

    private void printLottoResult() {
        WinningNumber winningNumbers = new WinningNumber(scanView.getWinningNumber(),
            scanView.getBonusNumber());
        Map<Rank, Integer> rankResult = getRankResultMap(winningNumbers);
        printView.printResult(rankResult, lottos.size() * PRICE_PER_LOTTO,
            getAmountOfWinningMoney(rankResult));
    }

    private Map<Rank, Integer> getRankResultMap(WinningNumber winningNumbers) {
        Map<Rank, Integer> rankResult = new HashMap<>();
        for (int i = 0; i < lottos.size(); i++) {
            Rank r = lottos.get(i).getResult(winningNumbers);
            int count = rankResult.getOrDefault(r, 0);
            rankResult.put(r, count + 1);
        }
        return rankResult;
    }

    private long getAmountOfWinningMoney(Map<Rank, Integer> rankResult) {
        long winningMoney = 0;
        for (Map.Entry<Rank, Integer> entry : rankResult.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            winningMoney += rank.getWinningMoney() * count;
        }
        return winningMoney;
    }

    public void printGame() {
        printView.printLottos(lottos, purchaseCount, manualPurchaseCount);
    }

}
