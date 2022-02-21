import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

	private static final List<Integer> allNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

	private List<Integer> numbers;

	public Lotto() {
		create();
	}

	private void create() {
		Collections.shuffle(allNumbers);
		numbers = allNumbers.subList(0, 6);
		Collections.sort(numbers);
		numbers = List.copyOf(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
