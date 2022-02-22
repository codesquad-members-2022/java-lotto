import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public List<Lotto> buyLotto(int inputMoney) {
        lottos = new ArrayList<>();

        int numOfLotto = inputMoney / Lotto.LOTTO_PRICE;
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
