package lotto.domain;

public class MatchLottoResult {
    private int matchNumberCount;
    private boolean hasBonus;

    public MatchLottoResult(int matchNumberCount, boolean hasBonus) {
        this.matchNumberCount = matchNumberCount;
        this.hasBonus = hasBonus;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}
