package domains.users;

import java.util.ArrayList;
import java.util.List;

import domains.winnings.BonusWinningNumbers;
import domains.winnings.Ranking;

public class Lottos {
    public static final int  MINIMUM_NUMBER_OF_WINNING = 3;
    private ArrayList<Lotto> lottos = new ArrayList<>();

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<List<Integer>> getTotalLottos(ArrayList<ArrayList<Integer>> tickets) {
        toLottos(tickets);

        return getPurchasedLottos();
    }

    private void toLottos(ArrayList<ArrayList<Integer>> tickets) {
        for (ArrayList<Integer> ticket : tickets) {
            this.purchased(ticket);
        }
    }

    private List<List<Integer>> getPurchasedLottos() {
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

    public Ranking getNumberOfWinningAboveThree(BonusWinningNumbers winningNumbers) {
        Ranking ranking = new Ranking();
        List<Integer> winning = winningNumbers.getNumbers();

        for (Lotto lotto : lottos) {
            int winningCount = lotto.countNumberOfWinnings(winning);
            if (winningCount >= MINIMUM_NUMBER_OF_WINNING) {
                boolean checkedBonus = lotto.getBonus(winningNumbers.getBonus());
                ranking.record(checkedBonus, winningCount);
            }
        }
       return ranking;
    }
}
