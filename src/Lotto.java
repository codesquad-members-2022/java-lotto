import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
	//todo
	// 6자리 숫자 랜덤으로 생성
	// 1, 2, 3, 4, 5, 6

	private List<Integer> numbers;
	private static final int PRICE = 1000;

	public Lotto() {
		this.numbers = new ArrayList<>();
		create();
	}

	private void create() {
		IntStream.rangeClosed(1, 45).forEach(a -> numbers.add(a));
		Collections.shuffle(numbers);
		numbers = numbers.subList(0, 6);
		Collections.sort(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
