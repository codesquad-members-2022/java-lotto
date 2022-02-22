package app.lotto.view;

import java.util.Map;

public class LottoResult {

    private final Map<Integer, Integer> statistics;
    private final int count;
    private final int winningCaseCount;
    private final long prizeMoney;
    private final long winAmount;

    private LottoResult(Map<Integer, Integer> statistics, int count, int winningCaseCount, long prizeMoney, long winAmount) {
        this.statistics = statistics;
        this.count = count;
        this.winningCaseCount = winningCaseCount;
        this.prizeMoney = prizeMoney;
        this.winAmount = winAmount;
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }

    public int getCount() {
        return count;
    }

    public int getWinningCaseCount() {
        return winningCaseCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public long getWinAmount() {
        return winAmount;
    }

    public static class Builder {
        private Map<Integer, Integer> statistics;
        private int count;
        private int winningCaseCount;
        private long prizeMoney;
        private long winAmount;

        public Builder setStatistics(Map<Integer, Integer> statistics) {
            this.statistics = statistics;
            return this;
        }

        public Builder setCount(int count) {
            this.count = count;
            return this;
        }

        public Builder setWinningCaseCount(int winningCaseCount) {
            this.winningCaseCount = winningCaseCount;
            return this;
        }

        public Builder setPrizeMoney(long prizeMoney) {
            this.prizeMoney = prizeMoney;
            return this;
        }

        public Builder setWinAmount(long winAmount) {
            this.winAmount = winAmount;
            return this;
        }

        public LottoResult build() {
            return new LottoResult(statistics, count, winningCaseCount, prizeMoney, winAmount);
        }
    }
}
