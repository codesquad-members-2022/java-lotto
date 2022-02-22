import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_EACH_MONEY = 1000;

    private final UserInterface ui = new UserInterface();
    private final LottoMaker lottoMaker = new LottoMaker();
    private List<Lotto> lottoList;

    public void run() {
        int purchaseMoney = buyLotto();

        List<Integer> winningNumbers = ui.inputWinningNumber();
        int bonusBall = ui.inputBonusBall(); // TODO
        WinningStatistic winningStatistic = new WinningStatistic(lottoList, winningNumbers);
        OutputView.showWinningStatistic(winningStatistic.getStatistic(), purchaseMoney);
    }

    private int buyLotto() {
        int purchaseMoney = ui.inputMoney();
        int lottoCount = purchaseMoney / LOTTO_EACH_MONEY;
        OutputView.showLottoCount(lottoCount);

        lottoList = createLottoList(lottoCount);
        OutputView.showLottoList(lottoList);

        return purchaseMoney;
    }

    private List<Lotto> createLottoList(int lottoCount) {
        // 로또 자동 생성
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            list.add(new Lotto(lottoMaker.autoMakeLotto()));
        }

        // 로또 수동 생성
        // TODO

        return list;
    }
}
