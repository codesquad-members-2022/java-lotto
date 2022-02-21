import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;

    public void start() {
        init();
        int inputMoney = Input.getInputMoney("구입금액을 입력해 주세요.");

        //구입금액에 맞춰서 로또를 생성해주는 메서드
        buyLotto(inputMoney);
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
