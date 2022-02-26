package domains.user;

import java.util.ArrayList;
import java.util.List;

import domains.winning.BonusWinningNumbers;
import domains.winning.Ranking;

public class Lottos {
    private ArrayList<Lotto> lottos = new ArrayList<>();

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void of(Tickets tickets) {
        toLottos(tickets);
    }

    private void toLottos(Tickets tickets) {
        for (List<Integer> ticket : tickets.getTotalLottos()) {
            this.purchased(ticket);
        }
    }

    private void purchased(List<Integer> pickedNumber){
        Lotto lotto = new Lotto(pickedNumber);
        this.lottos.add(lotto);
    }


    public Ranking getNumberOfWinningAboveThree(BonusWinningNumbers winningNumbers) {
        Ranking ranking = new Ranking();
        for (Lotto lotto : lottos) {
            lotto.recordRanking(winningNumbers, ranking);
        }
        return ranking;
    }
}
