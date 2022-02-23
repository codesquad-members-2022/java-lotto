package domains;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final int  MINIMUM_NUMBER_OF_WINNING = 3;
    private ArrayList<Lotto> lottos = new ArrayList<>();

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<List<Integer>> getTotalLottos(ArrayList<ArrayList<Integer>> tickets) {

        for (ArrayList<Integer> ticket : tickets) {
            this.purchased(ticket);
        }

        List<List<Integer>> purchasedLottos = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            List<Integer> numbers = lotto.numbers();
            purchasedLottos.add(numbers);
        }
        return purchasedLottos;
    }

    private void purchased(ArrayList<Integer> pickedNumber){
        Lotto lotto = new Lotto(pickedNumber);
        this.lottos.add(lotto);
    }

    public List<Integer> numberOfWinningAboveThree(List<Integer> winningNumbers) {
        List<Integer> resultOfLottos = this.lottos.stream()
            .mapToInt(lotto -> lotto.numberOfWinnings(winningNumbers))
            .filter(value -> value >= MINIMUM_NUMBER_OF_WINNING)
            .boxed()
            .collect(toList());
        return resultOfLottos;
    }
}
