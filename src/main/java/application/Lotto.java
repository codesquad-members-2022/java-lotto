package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Lotto {

    private List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            numbers.add(random.nextInt());
        }
    }

    public static Lotto generate() {
        return new Lotto();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
