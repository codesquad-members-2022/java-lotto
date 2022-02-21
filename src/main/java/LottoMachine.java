import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());


}
