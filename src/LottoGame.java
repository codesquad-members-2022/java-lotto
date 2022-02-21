import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public void run() {
        UserInterface ui = new UserInterface();
        int purchaseMoney = ui.inputMoney();
        int lottoCount = purchaseMoney / 1000;
        OutputView.showLottoCount(lottoCount);
        List<Lotto> lottoList = initLottoList(lottoCount);
        OutputView.showLottoList(lottoList);
        List<Integer> winningNumbers = ui.inputWinningNumber();
        WinningStatistic winningStatistic = new WinningStatistic(lottoList, winningNumbers);
        OutputView.showWinningStatistic(winningStatistic.getStatistic(), purchaseMoney);
    }

    private List<Lotto> initLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }
}
