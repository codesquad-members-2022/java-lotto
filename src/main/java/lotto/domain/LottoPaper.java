package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPaper {

    private final List<Lotto> lottos;

    public LottoPaper(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoSize() {
        return lottos.size();
    }

    public String showLottoPaper() {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos) {
            sb.append(lotto.showLottoNumbers()).append(System.lineSeparator());
        }

        return sb.toString();
    }

    public List<Integer> judgeWinning(List<Integer> winningNumbers) {
        return lottos.stream()
                .mapToInt(lotto -> lotto.getCorrectNumberCount(winningNumbers))
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Boolean> hasBonusNumbers(int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.hasBonusNumber(bonusNumber))
                .collect(Collectors.toList());
    }
}
