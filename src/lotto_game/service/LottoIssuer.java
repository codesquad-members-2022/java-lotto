package lotto_game.service;

import lotto_game.domain.Rank;
import lotto_game.domain.Lotto;
import lotto_game.domain.LottoResult;
import lotto_game.domain.LottoTicket;
import lotto_game.domain.WinningNumbers;
import lotto_game.util.Matcher;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoIssuer {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    public LottoTicket makeLottoTicket(int countOfLotto) {
        List<Lotto> lottos = IntStream.range(0, countOfLotto)
                .mapToObj(x -> new Lotto(makeRandomSixNumberList()))
                .collect(Collectors.toList());

        return new LottoTicket(lottos);
    }

    private List<Integer> makeRandomSixNumberList() {
        List<Integer> rangeOfNumberList = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());
        return pickRandomSixNumber(rangeOfNumberList);
    }

    private List<Integer> pickRandomSixNumber(List<Integer> rangeOfNumberList) {
        Collections.shuffle(rangeOfNumberList);
        return rangeOfNumberList.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }

    public LottoResult makeLottoResult(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        Matcher matcher = new Matcher();
        Map<Rank, Integer> resultMap = new HashMap<>() {{
            put(Rank.FIRST, 0);
            put(Rank.SECOND, 0);
            put(Rank.THIRD, 0);
            put(Rank.FOURTH, 0);
            put(Rank.FIFTH, 0);
        }};
        List<Lotto> lottosList = lottoTicket.getLottosList();

        for (int i = 0; i < lottoTicket.getLottosList().size(); i++) {
            // 각 로또의 6개 numbers에서 당첨번호 6개 numbers와 일치하는 number 갯수 구하기
            int matchCount = matcher.countLottoNumberMatchWinNumber(lottosList.get(i).getLottoNumbersList(), winningNumbers.getNumbersList());
            // 각 로또의 6개 numbers 중에서 보너스number와 일치하는 수가 있는지 체크
            boolean bonusNumberIsMatch = matcher.isMatchBonusNumber(lottosList.get(i).getLottoNumbersList(), winningNumbers.getBonusNumber());
            putResultMap(resultMap, matchCount, bonusNumberIsMatch);
        }
        return new LottoResult(resultMap);
    }

    private void putResultMap(Map<Rank, Integer> resultMap, int matchCount, boolean matchBonusNumber) {
        if (matchCount == 3) {
            resultMap.put(Rank.FIFTH, resultMap.get(Rank.FIFTH) + 1);
            return;
        }
        if (matchCount == 4) {
            resultMap.put(Rank.FOURTH, resultMap.get(Rank.FOURTH) + 1);
            return;
        }
        if (matchCount == 5 && !matchBonusNumber) {
            resultMap.put(Rank.THIRD, resultMap.get(Rank.THIRD) + 1);
            return;
        }
        if (matchCount == 5 && matchBonusNumber) {
            resultMap.put(Rank.SECOND, resultMap.get(Rank.SECOND) + 1);
            return;
        }
        if (matchCount == 6) {
            resultMap.put(Rank.FIRST, resultMap.get(Rank.FIRST) + 1);
            return;
        }
    }
}
