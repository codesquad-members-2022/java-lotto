import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistic {
    private Map<Integer, Integer> statistic;
    private List<Integer> winningNumbers;

    public WinningStatistic(List<Lotto> lottoList, List<Integer> winningNumbers) {
        statistic = new HashMap<>();
        initStatistic();
        this.winningNumbers = winningNumbers;
        for (int i = 0; i < lottoList.size(); i++) {
            int key = checkWinningNumber(lottoList.get(i));
            statistic.put(key, statistic.get(key) + 1);
        }
    }

    public Map<Integer, Integer> getStatistic() {
        return statistic;
    }

    private void initStatistic() {
        for (int i = 0; i < 7; i++) {
            statistic.put(i, 0);
        }
    }

    private int checkWinningNumber(Lotto lotto) {
        int winningCount = 0;
        for (int number : winningNumbers) {
            winningCount = checkInclusion(lotto.getNumbers().contains(number), winningCount);
        }
        return winningCount;
    }

    private int checkInclusion(boolean hasNumber, int winningCount) {
        if (hasNumber) {
            winningCount++;
        }
        return winningCount;
    }
}
