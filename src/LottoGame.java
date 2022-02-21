import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;
    private List<String> luckyNumbers;

    public void start() {
        init();
        int inputMoney = Input.getInputMoney("구입금액을 입력해 주세요.");
        buyLotto(inputMoney);
        this.luckyNumbers = Arrays.asList(Input.getLuckyNumbers());
    }

    private void init() {
        lottos = new ArrayList<>();
    }

    private void buyLotto(int inputMoney) {
        int numOfLotto = inputMoney / 1000;
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(new Lotto());
        }
        Output.printLottoNum(numOfLotto, lottos);
    }


}
