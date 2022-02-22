import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
        ArrayList<Integer> totalNumberList = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            totalNumberList.add(i);
        }
        Collections.shuffle(totalNumberList);
        for (int i = 0; i < 6; i++) {
            numbers.add(totalNumberList.get(i));
        }
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
