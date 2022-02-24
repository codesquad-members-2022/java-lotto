import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_EACH_MONEY = 1000;

    private final UserInterface ui = new UserInterface();
    private final LottoMaker lottoMaker = new LottoMaker();

    public void run() {
        int purchaseMoney = ui.inputMoney();
        int countOfLotto = purchaseMoney / LOTTO_EACH_MONEY;
        int countOfManualLotto = ui.inputCountOfManualLotto(countOfLotto);
        int countOfAutoLotto = countOfLotto - countOfManualLotto;
        List<String> manualLottoList = ui.inputManualLottoNumber(countOfManualLotto);
        OutputView.showCountOfLotto(countOfManualLotto, countOfAutoLotto);

        List<Lotto> lottoList = createLottoList(manualLottoList, countOfManualLotto, countOfAutoLotto);
        OutputView.showLottoList(lottoList);

        List<Integer> winningNumbers = ui.inputWinningNumber();
        int bonusBall = ui.inputBonusNumber();

        WinningStatistic winningStatistic = new WinningStatistic(lottoList, winningNumbers, bonusBall);
        OutputView.showWinningStatistic(winningStatistic.getResult(purchaseMoney));
    }

    private List<Lotto> createLottoList(List<String> manualLottoList, int countOfManualLotto, int countOfAutoLotto) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < countOfManualLotto; i++) {
            list.add(new Lotto(lottoMaker.makeManualLotto(manualLottoList.get(i))));
        }

        for (int i = 0; i < countOfAutoLotto; i++) {
            list.add(new Lotto(lottoMaker.makeAutoLotto()));
        }

        return list;
    }
}
