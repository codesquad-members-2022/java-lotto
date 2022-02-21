import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    private Map<Lotto, Integer> result;
    private List<Lotto> lottos;
    private List<Integer> luckyNumbers;

    public void start() {
        init();
        int inputMoney = Input.getInputMoney("구입금액을 입력해 주세요.");
        buyLotto(inputMoney);
        this.luckyNumbers = Arrays.stream(Input.getLuckyNumbers()).boxed()
            .collect(Collectors.toList());
        getResult();
        System.out.println();
    }

    private void getResult() {
        for (Lotto lotto : lottos) {
            int count = 0;
            for (int luckyNumber : luckyNumbers) {
                if (lotto.getNumbers().contains(luckyNumber)) {
                    count++;
                }
            }
            result.put(lotto, count);
        }
    }

    private void init() {
        lottos = new ArrayList<>();
        result = new HashMap<>();
    }

    private void buyLotto(int inputMoney) {
        int numOfLotto = inputMoney / 1000;
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(new Lotto());
        }
        Output.printLottoNum(numOfLotto, lottos);
    }


}
