import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
	//todo
	// 6자리 숫자 랜덤으로 생성
	// 1, 2, 3, 4, 5, 6

	private static List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

	private static final int PRICE = 1000;

	public Lotto() {
		create();
	}

	private void create() {
		Collections.shuffle(numbers);
		numbers = numbers.subList(0, 6);
		Collections.sort(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
