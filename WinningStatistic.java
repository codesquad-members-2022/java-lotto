import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistic {

    private Map<RankValue, Integer> statistic;
    private List<Integer> winningNumbers;

    public WinningStatistic(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusBall) {
        statistic = new LinkedHashMap<>();
        this.winningNumbers = winningNumbers;
        initStatistic();
        for (int i = 0; i < lottoList.size(); i++) {
            setStatistic(checkWinningNumber(lottoList.get(i)), checkBonus(lottoList.get(i), bonusBall));
        }
    }

    public String getResult(int purchaseMoney) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        sb.append("당첨 통계\n---------\n");
        for (RankValue rankValue : statistic.keySet()) {
            sb.append(rankValue.getCountOfMatch() + "개 일치 (" + rankValue.getWinningMoney() + "원)- " + statistic.get(rankValue) + "개\n" );
            sum += rankValue.getWinningMoney() * statistic.get(rankValue);
        }
        sb.append("총 수익률은 " + (((float) sum - purchaseMoney) * 100 / purchaseMoney) + "입니다.");
        return sb.toString();
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
        return lotto.containNumber(bonusBall);
    }

    private int checkWinningNumber(Lotto lotto) {
        int countOfWinningNumber = 0;
        for (int number : winningNumbers) {
            countOfWinningNumber = checkInclusion(lotto.containNumber(number), countOfWinningNumber);
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
