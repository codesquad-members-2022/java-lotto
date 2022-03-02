package lotto_game.domain;

import java.util.Map;

public class LottoResult {
    Map<Rank, Integer> resultMap;

    public LottoResult(Map<Rank, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }
}
