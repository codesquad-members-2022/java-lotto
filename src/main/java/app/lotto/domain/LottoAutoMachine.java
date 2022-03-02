package app.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<LottoTicket> getAllAutoLottoNumbers(int autoLottoCount) {
        List<LottoTicket> allAutoLottoNumbers = new ArrayList<>();

        for (int i = 0; i < autoLottoCount; i++) {
            LottoTicket autoLottoNumbers = getAutoLottoNumbers();
            allAutoLottoNumbers.add(autoLottoNumbers);
        }

        return allAutoLottoNumbers;
    }

    public static int getLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    private static LottoTicket getAutoLottoNumbers() {
        List<Integer> lottoNumbers = getLottoNumbers();
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(0, LOTTO_NUMBER_COUNT));
    }

    private static List<Integer> getLottoNumbers() {
        return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

}
