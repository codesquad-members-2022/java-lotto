package application.domain;


import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int AMOUNT_LOTTO_NUMBER = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != AMOUNT_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != AMOUNT_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(i -> i < 1 || i > 45)) {
            throw new IllegalArgumentException("범위를 벗어났습니다.");
        }
    }

    public boolean isContainBonusBallNumber(int bonusBall) {
        return numbers.contains(bonusBall);
    }

    public int getTheNumberOfMatches(Lotto userWinningNumber) {
        int count = 0;
        List<Integer> thisNumbers = this.numbers;
        int thisNumbersPointer = 0;
        List<Integer> userWinningNumbers = userWinningNumber.numbers;
        int userWinningNumbersPointer = 0;

        while (thisNumbersPointer < AMOUNT_LOTTO_NUMBER && userWinningNumbersPointer < AMOUNT_LOTTO_NUMBER) {
            if (Objects.equals(thisNumbers.get(thisNumbersPointer), userWinningNumbers.get(userWinningNumbersPointer))) {
                count++;
                thisNumbersPointer++;
                userWinningNumbersPointer++;
            } else if (thisNumbers.get(thisNumbersPointer) > userWinningNumbers.get(userWinningNumbersPointer)) {
                userWinningNumbersPointer++;
            } else if (thisNumbers.get(thisNumbersPointer) < userWinningNumbers.get(userWinningNumbersPointer)) {
                thisNumbersPointer++;
            }
        }
        return count;
    }


    public String lottoNumbersToString() {
        return numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
