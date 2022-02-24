import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_EACH_MONEY = 1000;

    private final UserInterface ui = new UserInterface();
    private final LottoMaker lottoMaker = new LottoMaker();
    private List<Lotto> lottoList;

    public void run() {
        int purchaseMoney = inputLottoInfo();

        List<Integer> winningNumbers = ui.inputWinningNumber();
        int bonusBall = ui.inputBonusBall(); // TODO
        WinningStatistic winningStatistic = new WinningStatistic(lottoList, winningNumbers, bonusBall);
        OutputView.showWinningStatistic(winningStatistic.getStatistic(), purchaseMoney);
    }

    private int inputLottoInfo() {
        int purchaseMoney = ui.inputMoney();
        int countOfLotto = purchaseMoney / LOTTO_EACH_MONEY;
        int countOfManualLotto = ui.inputCountOfManualLotto();
        int countOfAutoLotto = countOfLotto - countOfManualLotto;
        List<String> manualLottoList = ui.inputManualLottoNumber(countOfManualLotto);

        OutputView.showCountOfLotto(countOfManualLotto, countOfAutoLotto);

        lottoList = createLottoList(manualLottoList, countOfManualLotto, countOfAutoLotto);
        OutputView.showLottoList(lottoList);

        return purchaseMoney;
    }

    private List<Lotto> createLottoList(List<String> manualLottoList, int countOfManualLotto, int countOfAutoLotto) {
        List<Lotto> list = new ArrayList<>();
        // 로또 수동 생성
        for (int i = 0; i < countOfManualLotto; i++) {
            list.add(new Lotto(lottoMaker.makeManualLotto(manualLottoList.get(i))));
        }

        // 로또 자동 생성
        for (int i = 0; i < countOfAutoLotto; i++) {
            list.add(new Lotto(lottoMaker.makeAutoLotto()));
        }

        return list;
    }
}
