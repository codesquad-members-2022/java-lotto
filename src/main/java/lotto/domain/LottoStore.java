package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoStore {
    private static final int LOTTO_PRICE = 1_000;
    private static final int MIN_NUMBER_LENGTH = 1;
    private static final int MAX_NUMBER_LENGTH = 45;

    private List<Integer> allLottoNumber;

    public LottoStore() {
        this.allLottoNumber = getAllLottoNumber();
    }

    private List<Integer> getAllLottoNumber() {
        this.allLottoNumber = new ArrayList<>();

        for (int i = MIN_NUMBER_LENGTH; i <= MAX_NUMBER_LENGTH; i++) {
            this.allLottoNumber.add(i);
        }

        return this.allLottoNumber;
    }

    public LottoPaper purchase(int purchaseAmount, int manualLottoCount, Map<Integer, List<Integer>> numbers) {
        int lottoCount = getLottoCount(purchaseAmount);

        List<Lotto> lottos = createLottos(manualLottoCount, lottoCount - manualLottoCount, numbers);

        return new LottoPaper(lottos);
    }

    private int getLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> createLottos(int manualLottoCount, int autoLottoCount, Map<Integer, List<Integer>> numbers) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < manualLottoCount; i++) {
            lottos.add(new ManualLotto(numbers.get(i)));
        }

        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(new AutoLotto(allLottoNumber));
        }

        return lottos;
    }
}
