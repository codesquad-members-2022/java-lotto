import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final List<Integer> numbers = initNumbers();

    private static List<Integer> initNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }

}
