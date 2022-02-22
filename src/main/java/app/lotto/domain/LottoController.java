package app.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// - 구매 금액을 받아서, 로또 번호를 생성해주는 클래스
public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    public static List<List<Integer>> getAllShuffledNumbers(int amount) {
        int lottoCount = getLottoCount(amount);
        List<List<Integer>> allShuffledNumbers = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> shuffledNumbers = getShuffledNumbers();
            allShuffledNumbers.add(shuffledNumbers);
        }

        return allShuffledNumbers;
    }

    public static int getLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    private static List<Integer> getShuffledNumbers() {
        List<Integer> lottoNumbers = getLottoNumbers();

        Collections.shuffle(lottoNumbers);

        List<Integer> shuffledNumbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            shuffledNumbers.add(lottoNumbers.get(i));
        }

        return shuffledNumbers;
    }

    private static List<Integer> getLottoNumbers() {
        return IntStream.rangeClosed(1,45)
                .boxed()
                .collect(Collectors.toList());
    }

}
