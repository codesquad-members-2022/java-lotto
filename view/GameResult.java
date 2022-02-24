package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.Rank;
import PACKAGE_NAME.domain.RateOfReturn;

import java.util.Map;

public class GameResult {

    private Map<Rank, Integer> matchOfRank;
    private RateOfReturn rateOfReturn;

    public GameResult(Map<Rank, Integer> matchOfRank, RateOfReturn rateOfReturn) {
        this.matchOfRank = matchOfRank;
        this.rateOfReturn = rateOfReturn;
    }

    public Map<Rank, Integer> getMatchOfRank() {
        return matchOfRank;
    }

    public RateOfReturn getRateOfReturn() {
        return rateOfReturn;
    }
}
