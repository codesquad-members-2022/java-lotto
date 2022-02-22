import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public void run() {
        UserInterface ui = new UserInterface();
        int purchaseMoney = ui.inputMoney();
        int lottoCount = purchaseMoney / 1000;
        OutputView.showLottoCount(lottoCount);

        List<Lotto> lottoList = createLottoList(lottoCount);
        OutputView.showLottoList(lottoList);

    }

    private List<Lotto> createLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }
}
