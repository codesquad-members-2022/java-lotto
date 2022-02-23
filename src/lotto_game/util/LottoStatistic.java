package lotto_game.util;

import lotto_game.domain.Rank;
import lotto_game.domain.LottoResult;

import java.util.*;

public class LottoStatistic {

    public int calculateProfitRate(LottoResult lottoResult, int purchaseMoney) {
        return getProfitRate(calculateWinningMoney(lottoResult), purchaseMoney);
    }

    private int calculateWinningMoney(LottoResult lottoResult) {
        int winningMoney = 0;
        Map<Rank, Integer> resultMap = lottoResult.getResultMap();

        for (Map.Entry<Rank, Integer> elem : resultMap.entrySet()){
            Rank rank = elem.getKey();
            int count = elem.getValue();
            winningMoney += rank.getWinnings() * count;
        }
        return winningMoney;
    }

    private int getProfitRate(int winningMoney, int purchaseMoney) {
        return (winningMoney - purchaseMoney) / purchaseMoney * 100;
    }
}
