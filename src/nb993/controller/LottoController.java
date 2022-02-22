package nb993.controller;

import java.util.ArrayList;
import nb993.model.LottoTicket;
import nb993.view.PrintView;
import nb993.view.ScanView;

import java.util.List;

public class LottoController {

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
        int purchaseCount = purchaseAmount / 1000;

        for (int i = 0; i < purchaseCount; ++i) {
            lottos.add(new LottoTicket());
        }
    }

    public void playGame() {
        initLottos();
        printGame();
        printLottoResult();
    }

    private void printLottoResult() {
        int[] winningNumbers = scanView.getWinningNumber();
        int[] result = new int[7];

        for (int i = 0; i < lottos.size(); i++) {
            result[lottos.get(i).getResult(winningNumbers)]++;
        }
        printView.printResult(result, 1000 * lottos.size());
    }

    public void printGame() {
        printView.printLottos(lottos);
    }


}
