package PACKAGE_NAME.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static List<Integer> lottoNumbers = new ArrayList<>();

    static {
        init();
    }

    private static void init() {
        IntStream.rangeClosed(1, 45)
                .boxed()
                .forEach(number -> lottoNumbers.add(number));
    }

    // 섞고 -> 6개를 뽑는 메서드
    public List<Integer> getLottoNumbers() {
        shuffle();
        return getSixNumbers();
    }

    private void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    private List<Integer> getSixNumbers() {
        return lottoNumbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
