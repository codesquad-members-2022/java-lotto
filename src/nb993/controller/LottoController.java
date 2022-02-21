package nb993.controller;

import java.util.ArrayList;
import nb993.model.Lotto;
import nb993.view.PrintView;
import nb993.view.ScanView;

import java.util.List;

public class LottoController {

    private final ScanView scanView;
    private final PrintView printView;
    private List<Lotto> lottos;

    public LottoController(ScanView scanView, PrintView printView) {
        this.scanView = scanView;
        this.printView = printView;
    }

    public void initLottos() {
        this.lottos = new ArrayList<>();
        int purchaseAmount = scanView.getPurchaseAmount();
        int purchaseCount = purchaseAmount / 1000;

        for (int i = 0; i < purchaseCount; ++i) {
            lottos.add(new Lotto());
        }
    }

    public void playGame() {
        initLottos();
        printGame();
        printLottoResult();
    }

    private void printLottoResult() {
        int[] winningNumbers = scanView.getWinningNumber();
    }

    public void printGame() {
        printView.printLottos(lottos);
    }


}
