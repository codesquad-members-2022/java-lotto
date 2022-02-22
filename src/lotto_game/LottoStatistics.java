package lotto_game;

import lotto_game.domain.LottoGames;
import lotto_game.domain.LottoResult;

import java.util.*;

public class LottoStatistics {
    public static final int MATCH = 1;
    public static final int DIFFER = 0;

    private LottoResult lottoResult;

    public LottoStatistics() {
        this.lottoResult = new LottoResult();
    }

    public int calculateProfitRate(String winNumbers, LottoGames lottoGames, int purchaseMoney) {
        int[] winNumbersArr = Arrays.stream(winNumbers.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int winningAmount = 0;
        for (int i = 0; i < lottoGames.getLottoList().size(); i++) {
            MatchNumber matchNumber = countLottoNumberMatchWinNumber(lottoGames.getLottoList().get(i).getLottoNumberList(), winNumbersArr);
            winningAmount += matchNumber.getWinnings();
        }
        return getProfitRate(winningAmount, purchaseMoney);
    }

    private int getProfitRate(int winningAmount, int purchaseMoney) {
        return (winningAmount - purchaseMoney) / purchaseMoney * 100;
    }

    private MatchNumber countLottoNumberMatchWinNumber(List<Integer> lottoNumberList, int[] winNumbersArr) {
        int matchCount = 0;
        int bonusNumber = winNumbersArr[winNumbersArr.length - 1];
        for (int i = 0; i < winNumbersArr.length; i++) {
            matchCount += lottoNumberListHasWinNumber(lottoNumberList, winNumbersArr[i]);
        }
        return convertMatchCountToMatchNumber(matchCount, isMatchBonusNumber(lottoNumberList, bonusNumber));
    }

    private boolean isMatchBonusNumber(List<Integer> lottoNumberList, int bonusNumber) {
        if (lottoNumberListHasWinNumber(lottoNumberList, bonusNumber) == MATCH) {
            return true;
        }
        return false;
    }

    private MatchNumber convertMatchCountToMatchNumber(int matchCount, boolean matchBonusNumber) {
        if (matchCount == 3) {
            lottoResult.addMatchNumberCount(MatchNumber.THREE);
            return MatchNumber.THREE;
        }
        if (matchCount == 4) {
            lottoResult.addMatchNumberCount(MatchNumber.FOUR);
            return MatchNumber.FOUR;
        }
        if (matchCount == 5 && !matchBonusNumber) {
            lottoResult.addMatchNumberCount(MatchNumber.FIVE);
            return MatchNumber.FIVE;
        }
        if (matchCount == 5 && matchBonusNumber) {
            lottoResult.addMatchNumberCount(MatchNumber.FIVE_CONTAIN_BONUS);
            return MatchNumber.FIVE_CONTAIN_BONUS;
        }
        if (matchCount == 6) {
            lottoResult.addMatchNumberCount(MatchNumber.SIX);
            return MatchNumber.SIX;
        }
        return MatchNumber.ZERO_TO_TWO;
    }

    private int lottoNumberListHasWinNumber(List<Integer> lottoNumberList, int winNumber) {
        if (lottoNumberList.contains(winNumber)) {
            return MATCH;
        }
        return DIFFER;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
