package domains;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class Lottos {
    private ArrayList<Lotto> lottos = new ArrayList<>();

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void purchased(ArrayList<Integer> autoPickedNumber){
        Lotto lotto = new Lotto(autoPickedNumber);
        this.lottos.add(lotto);
    }

    public List<List<Integer>> getPurchasedLottos() {
        List<List<Integer>> purchasedLottos = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            List<Integer> numbers = lotto.numbers();
            purchasedLottos.add(numbers);
        }
        return purchasedLottos;
    }

    public int compareResult(List<Integer> winningNumbers){
        OptionalInt max = this.lottos.stream()
                .mapToInt(lotto -> lotto.numberOfWinnings(winningNumbers))
                .max();
        return max.getAsInt();
    }
}
