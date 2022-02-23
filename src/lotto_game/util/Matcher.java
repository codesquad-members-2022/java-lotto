package lotto_game.util;

import java.util.List;

public class Matcher {
    public static final int MATCH = 1;
    public static final int DIFFER = 0;

    public int countLottoNumberMatchWinNumber(List<Integer> lottoNumberList, List<Integer> winningNumberList) {
        int matchCount = 0;
        for (int i = 0; i < winningNumberList.size(); i++) {
            matchCount += lottoNumberListHasWinNumber(lottoNumberList, winningNumberList.get(i));
        }
        return matchCount;
    }

    public boolean isMatchBonusNumber(List<Integer> lottoNumberList, int bonusNumber) {
        if (lottoNumberListHasWinNumber(lottoNumberList, bonusNumber) == MATCH) {
            return true;
        }
        return false;
    }

    private int lottoNumberListHasWinNumber(List<Integer> lottoNumberList, int winNumber) {
        if (lottoNumberList.contains(winNumber)) {
            return MATCH;
        }
        return DIFFER;
    }
}
