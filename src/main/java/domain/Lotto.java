package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public String getLottoNumbers() {
        return lottoNumbers.toString();
    }

    public int size() {
        return lottoNumbers.size();
    }
}
