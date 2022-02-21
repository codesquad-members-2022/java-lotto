import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        //Collections.shuffle(numbers);
        this.numbers = numbers;
        sort();
    }

    private void sort() {
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
