package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public boolean sameList(List<Integer> lists) {
        return numbers.containsAll(lists);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
