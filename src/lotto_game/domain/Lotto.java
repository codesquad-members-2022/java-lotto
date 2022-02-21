package lotto_game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numberList;
    private List<Integer> lottoNumbers;

    public Lotto() {
        this.numberList = new ArrayList<>();
        this.lottoNumbers = new ArrayList<>();
    }

    public void initLottoNumbers() {
        initNumberList();
        shuffleNumberList();
        addLottoNumbersPickSixNumbersAtNumberList();
        sortLottoNumbers();
    }

    private void initNumberList() {
        for (int i = 1; i <= 45; i++) {
            this.numberList.add(i);
        }
    }

    private void shuffleNumberList() {
        Collections.shuffle(this.numberList);
    }

    private void addLottoNumbersPickSixNumbersAtNumberList() {
        for (int i = 0; i < 6; i++) {
            this.lottoNumbers.add(this.numberList.get(i));
        }
    }

    private void sortLottoNumbers() {
        Collections.sort(this.lottoNumbers);
    }

    public List<Integer> getLottoNumberList() {
        return this.lottoNumbers;
    }
}
