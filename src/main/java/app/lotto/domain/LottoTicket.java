package app.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        lottoNumbers = new ArrayList<>();
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
