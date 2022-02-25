package domain;

import java.util.List;

public class PurchasedLotto extends Lotto{

    public PurchasedLotto(List<Integer> numbers) {
        super(numbers);
    }

    public int check(Lotto lotto) {
        int count = 0;

        for (int index = 0; index < LOTTO_SIZE; index++) {
            count += countContainNumber(lotto, index);
        }

        return count;
    }

    private int countContainNumber(Lotto lotto, int index) {
        int count = 0;

        if (numbers.contains(lotto.numbers.get(index))) {
            count++;
        }

        return count;
    }

    @Override
    public String toString() {
        return numbers + "";
    }

}
