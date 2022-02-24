package app.lotto.domain;

import app.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoMachine {

    private static final int LOTTO_PRICE = 1000;

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
        LottoTicket shuffledNumbers = new LottoTicket();

        for (int i = 0; i < 6; i++) {
            shuffledNumbers.addNumber(lottoNumbers.get(i));
        }

        return shuffledNumbers;
    }

    private static List<Integer> getLottoNumbers() {
        return IntStream.rangeClosed(1,45)
                .boxed()
                .collect(Collectors.toList());
    }

}
