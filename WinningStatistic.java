import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistic {
    private Map<RankValue, Integer> statistic;
    private List<Integer> winningNumbers;

    public WinningStatistic(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusBall) {
        statistic = new LinkedHashMap<>();
        initStatistic();
        this.winningNumbers = winningNumbers;
        for (int i = 0; i < lottoList.size(); i++) {
            setStatistic(checkWinningNumber(lottoList.get(i)), checkBonus(lottoList.get(i), bonusBall));
        }
    }

    public Map<RankValue, Integer> getStatistic() {
        return statistic;
    }

    private void initStatistic() {
        for (RankValue rankValue : RankValue.values()) {
            statistic.put(rankValue, 0);
        }
    }

    private void setStatistic(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < 3) {
            return;
        }
        RankValue key = RankValue.valueOf(countOfMatch, matchBonus);
        statistic.put(key, statistic.getOrDefault(key, 0) + 1);
    }

    private boolean checkBonus(Lotto lotto, int bonusBall) {
        return lotto.getNumbers().contains(bonusBall);
    }

    private int checkWinningNumber(Lotto lotto) {
        int countOfWinningNumber = 0;
        for (int number : winningNumbers) {
            countOfWinningNumber = checkInclusion(lotto.getNumbers().contains(number), countOfWinningNumber);
        }

        return countOfWinningNumber;
    }

    private int checkInclusion(boolean hasNumber, int countOfWinningNumber) {
        if (hasNumber) {
            countOfWinningNumber++;
        }

        return countOfWinningNumber;
    }
}
