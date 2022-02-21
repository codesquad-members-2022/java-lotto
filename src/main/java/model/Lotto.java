package model;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean sameList(List<Integer> lists) {
        return numbers.containsAll(lists);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
