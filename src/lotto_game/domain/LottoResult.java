package lotto_game.domain;

import lotto_game.MatchNumber;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    Map<MatchNumber, Integer> resultMap;

    public LottoResult() {
        this.resultMap = new HashMap<>() {{
            put(MatchNumber.THREE, 0);
            put(MatchNumber.FOUR, 0);
            put(MatchNumber.FIVE, 0);
            put(MatchNumber.SIX, 0);
        }};
    }

    public Map<MatchNumber, Integer> getResultMap() {
        return resultMap;
    }

    public void addMatchNumberCount(MatchNumber matchNumber) {
        if (matchNumber == MatchNumber.THREE) {
            this.resultMap.put(MatchNumber.THREE, this.resultMap.get(MatchNumber.THREE) + 1);
        }
        if (matchNumber == MatchNumber.FOUR) {
            this.resultMap.put(MatchNumber.FOUR, this.resultMap.get(MatchNumber.FOUR) + 1);
        }
        if (matchNumber == MatchNumber.FIVE) {
            this.resultMap.put(MatchNumber.FIVE, this.resultMap.get(MatchNumber.FIVE) + 1);
        }
        if (matchNumber == MatchNumber.SIX) {
            this.resultMap.put(MatchNumber.SIX, this.resultMap.get(MatchNumber.SIX) + 1);
        }
    }
}
