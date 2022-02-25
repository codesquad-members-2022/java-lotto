import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> lottoNumberList) {
        numbers = lottoNumberList;
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }
}
