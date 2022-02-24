package domains;

import domains.WinningNumbers;

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

    public ArrayList<Lotto> get(){
        return this.lottos;
    }

    public List<Integer> getNumberOfWinningAboveThree(WinningNumbers winningNumbers) {
        List<Integer> winning = winningNumbers.getNumbers();
        int threeBall = 0;
        int fourBall = 0;
        int fiveBall = 0;
        int bonusFiveBall = 0;
        int sixBall = 0;
        for (Lotto lotto : lottos) {
            int winningCount = lotto.countNumberOfWinnings(winning);
            if (winningCount >= MINIMUM_NUMBER_OF_WINNING){
                switch (winningCount) {
                    case 3 :
                        threeBall++;
                        break;
                    case 4 :
                        if (lotto.getBonus(winningNumbers.getBonusBall())){
                            fiveBall++;
                            break;
                        }fourBall++;
                        break;
                    case 5 :
                        fiveBall++;
                        break;
                    case 6 :
                        sixBall++;
                        break;
                }
            }
        }
        return null;
    }
}
