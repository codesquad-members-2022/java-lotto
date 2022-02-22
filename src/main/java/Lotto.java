import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        sort();
    }

    private void sort() {
        Collections.sort(numbers);
    }

    public int check(int[] winingNumber) {
        int count = 0;

        for (int i = 0; i < winingNumber.length; i++) {
            if(numbers.contains(winingNumber[i])) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        return numbers + "";

    }
}
