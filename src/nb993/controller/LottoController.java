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
    private Map<Rank, Integer> rankResult;
    private long amountOfWinningMoney;
    private int purchaseAmount;
    private WinningNumber winningNumbers;

    public LottoController(ScanView scanView, PrintView printView) {
        this.lottos = new ArrayList<>();
        this.scanView = scanView;
        this.printView = printView;
    }

    public void playGame() {
        initLottos();
        printLottoResult();
    }

    public void initLottos() {
        setPurchaseAmount();
        setPurchaseCount();
        setManualPurchaseCount();

        setManualLottoTickets();
        setAutoLottoTickets();

        printGame();

        setWinningNumbers();
        setRankResultMap();
        setAmountOfWinningMoney();
    }

    private void setPurchaseAmount() {
        purchaseAmount = scanView.getPurchaseAmount();
    }

    private void setPurchaseCount() {
        purchaseCount = purchaseAmount / PRICE_PER_LOTTO;
    }

    private void setManualPurchaseCount() {
        manualPurchaseCount = scanView.getManualPurchaseCount(purchaseCount);
    }


    private void setManualLottoTickets() {
        if (manualPurchaseCount == 0) {
            return;
        }
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualPurchaseCount; i++) {
            createManualLottoTicket();
        }
    }

    private void createManualLottoTicket() {
        try {
            System.out.print("[" + lottos.size() + "] : ");
            lottos.add(new LottoTicket(scanView.getNumbers()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createManualLottoTicket();
        }
    }

    private void setAutoLottoTickets() {
        for (int i = 0; i < purchaseCount - manualPurchaseCount; ++i) {
            lottos.add(new LottoTicket());
        }
    }


    private void printLottoResult() {
        printView.printResult(rankResult, purchaseAmount, amountOfWinningMoney);
    }

    private void setRankResultMap() {
        rankResult = new HashMap<>();
        for (int i = 0; i < lottos.size(); i++) {
            Rank r = lottos.get(i).getResult(winningNumbers);
            int count = rankResult.getOrDefault(r, 0);
            rankResult.put(r, count + 1);
        }
    }

    private void setAmountOfWinningMoney() {
        for (Map.Entry<Rank, Integer> entry : rankResult.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            amountOfWinningMoney += (long)rank.getWinningMoney() * count;
        }
    }

    private void setWinningNumbers() {
        try {
            winningNumbers = new WinningNumber(scanView.getWinningNumber(),
                scanView.getBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinningNumbers();
        }
    }

    public void printGame() {
        printView.printLottos(lottos, purchaseCount, manualPurchaseCount);
    }

}
