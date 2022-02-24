import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_EACH_MONEY = 1000;

    private final UserInterface ui = new UserInterface();

    public void run() {
        int purchaseMoney = ui.inputMoney();
        int countOfLotto = purchaseMoney / LOTTO_EACH_MONEY;
        int countOfManualLotto = ui.inputCountOfManualLotto(countOfLotto);
        int countOfAutoLotto = countOfLotto - countOfManualLotto;

        List<Lotto> manualLottoList = new ManualLottoMaker(ui.inputManualLottoNumber(countOfManualLotto)).getLottoList(countOfManualLotto);
        List<Lotto> autoLottoList = new AutoLottoMaker().getLottoList(countOfAutoLotto);
        List<Lotto> totalLottoList = combineList(manualLottoList, autoLottoList);

        OutputView.showCountOfLotto(countOfManualLotto, countOfAutoLotto);
        OutputView.showLottoList(totalLottoList);

        List<Integer> winningNumbers = ui.inputWinningNumber();
        int bonusBall = ui.inputBonusNumber();

        WinningStatistic winningStatistic = new WinningStatistic(totalLottoList, winningNumbers, bonusBall);
        OutputView.showWinningStatistic(winningStatistic.getResult(purchaseMoney));
    }

    private List<Lotto> combineList(List<Lotto> manualLottoList, List<Lotto> autoLottoList) {
        List<Lotto> list = new ArrayList<>();
        list.addAll(manualLottoList);
        list.addAll(autoLottoList);

        return list;
    }
}
