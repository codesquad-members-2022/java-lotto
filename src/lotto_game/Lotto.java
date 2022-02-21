package lotto_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;
    public Lotto() {
        lottoNumbers = getNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> sixNumber = getNumbersToSixNumber(numbers);
        Collections.sort(sixNumber);
        return sixNumber;
    }

    private List<Integer> getNumbersToSixNumber(List<Integer> numbers) {
        List<Integer> sixNumber = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            sixNumber.add(numbers.get(i));
        }
        return sixNumber;
    }

}
