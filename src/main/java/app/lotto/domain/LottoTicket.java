package app.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    public static LottoTicket createWithStringNumbers(String[] numbers) {
        return new LottoTicket(Arrays.stream(numbers)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
    }

    public LottoTicket() {
        lottoNumbers = new ArrayList<>();
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this();
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public void addNumber(int number) {
        lottoNumbers.add(number);
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

    public void sort() {
        Collections.sort(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
