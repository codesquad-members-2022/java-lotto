package app.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public static LottoTicket createWithStringNumbers(String[] numbers) {
        return new LottoTicket(Arrays.stream(numbers)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted()
                .collect(Collectors.toList()));
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers.addAll(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    public int getNumber(int index) {
        return lottoNumbers.get(index);
    }

    public int getSize() {
        return lottoNumbers.size();
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
