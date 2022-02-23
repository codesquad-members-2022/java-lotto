package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

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

    public boolean contains(int number){
        return lottoNumbers.contains(number);
    }
}
