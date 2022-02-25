package lotto.domain;

import java.util.List;

public abstract class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = createLotto(numbers);
    }

    public abstract List<Integer> createLotto(List<Integer> numbers);

    public String showLottoNumbers() {
        return numbers.toString();
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    private int correctNumber(int number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public MatchLottoResult match(WinningLotto winningLotto) {
        int matchCount = (int)numbers.stream()
                .filter(value -> winningLotto.hasNumber(value))
                .count();

        return new MatchLottoResult(matchCount, numbers.contains(winningLotto.getBonusNumber()));
    }
}
