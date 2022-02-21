import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;

    public List<Lotto> buyLotto(int inputMoney) {
        lottos = new ArrayList<>();

        int numOfLotto = inputMoney / LOTTO_PRICE;
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
