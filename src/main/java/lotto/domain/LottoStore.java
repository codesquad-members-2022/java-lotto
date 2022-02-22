package lotto.domain;

import java.util.ArrayList;
import java.util.List;

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

    private int getLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public LottoPaper purchase(int purchaseAmount) {
        int lottoCount = getLottoCount(purchaseAmount);

        List<Lotto> lottos = createLottos(lottoCount);

        return new LottoPaper(lottos);
    }

    private List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(allLottoNumber));
        }

        return lottos;
    }
}
