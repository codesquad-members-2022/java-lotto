package app.lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeResultCalculator {

    public Map<LottoPrize, Integer> getStatistics(LottoGameDto lottoGameDto) {
        Map<LottoPrize, Integer> statistics = new HashMap<>();

        List<LottoTicket> allLottoTicket = lottoGameDto.getAllLottoTickets();

        for (LottoTicket lottoTicket : allLottoTicket) {
            int sameNumberCount = getSameNumberCount(lottoTicket, lottoGameDto.getWinningLottoNumbers().getWinningNumbers());
            boolean isBonus = lottoTicket.contains(lottoGameDto.getWinningLottoNumbers().getBonusNumber());

            addCountToStatistics(statistics, sameNumberCount, isBonus);
        }
        return statistics;
    }

    private void addCountToStatistics(Map<LottoPrize, Integer> statistics, int sameNumberCount, boolean isBonus) {
        if (LottoPrize.isLottoPrize(sameNumberCount)) {
            LottoPrize lottoPrize = LottoPrize.findLottoPrize(sameNumberCount, isBonus)
                    .orElseThrow(() -> new IllegalStateException("당첨 여부 확인 중 오류가 발생하였습니다."));
            int value = statistics.getOrDefault(lottoPrize, 0);
            value++;
            statistics.put(lottoPrize, value);
        }
    }

    private int getSameNumberCount(LottoTicket shuffledNumbers, LottoTicket winningNumbers) {
        int count = 0;

        for (int i = 0; i < shuffledNumbers.getSize(); i++) {
            count = getCount(winningNumbers, count, shuffledNumbers.getNumber(i));
        }

        return count;
    }

    private int getCount(LottoTicket winningNumbers, int count, int number) {
        if (winningNumbers.contains(number)) {
            count++;
        }
        return count;
    }
}
