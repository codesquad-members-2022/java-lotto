import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> lottoNumberList) {
        numbers = lottoNumberList;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
