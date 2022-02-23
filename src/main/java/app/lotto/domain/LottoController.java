package app.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// - 구매 금액을 받아서, 로또 번호를 생성해주는 클래스
public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    public static List<LottoTicket> getAllShuffledNumbers(int autoLottoCount) {
        List<LottoTicket> allShuffledNumbers = new ArrayList<>();

        for (int i = 0; i < autoLottoCount; i++) {
            LottoTicket shuffledNumbers = getShuffledNumbers();
            allShuffledNumbers.add(shuffledNumbers);
        }

        return allShuffledNumbers;
    }

    public static int getLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    private static LottoTicket getShuffledNumbers() {
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
