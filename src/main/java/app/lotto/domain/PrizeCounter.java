package app.lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeCounter {

    public static Map<LottoPrize, Integer> getStatistics(LottoGameResult lottoGameResult) {
        Map<LottoPrize, Integer> statistics = new HashMap<>();

        List<LottoTicket> allLottoTicket = lottoGameResult.getAllLottoTickets();

        for (LottoTicket lottoTicket : allLottoTicket) {
            int sameNumberCount = getSameNumberCount(lottoTicket, lottoGameResult.getWinningNumbers());
            boolean isBonus = lottoTicket.contains(lottoGameResult.getBonusNumber());

            addCountToStatistics(statistics, sameNumberCount, isBonus);
        }
        return statistics;
    }

    private static void addCountToStatistics(Map<LottoPrize, Integer> statistics, int sameNumberCount, boolean isBonus) {
        if (LottoPrize.isLottoPrize(sameNumberCount)) {
            LottoPrize lottoPrize = LottoPrize.findLottoPrize(sameNumberCount, isBonus)
                    .orElseThrow(() -> new IllegalStateException("당첨 여부 확인 중 오류가 발생하였습니다."));
            int value = statistics.getOrDefault(lottoPrize, 0);
            value++;
            statistics.put(lottoPrize, value);
        }
    }

    private static int getSameNumberCount(LottoTicket shuffledNumbers, LottoTicket winningNumbers) {
        int count = 0;

        for (int i = 0; i < shuffledNumbers.getSize(); i++) {
            count = getCount(winningNumbers, count, shuffledNumbers.getNumber(i));
        }

        return count;
    }

    private static int getCount(LottoTicket winningNumbers, int count, int number) {
        if (winningNumbers.contains(number)) {
            count++;
        }
        return count;
    }
}
