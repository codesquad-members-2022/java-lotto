package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final String WINNING_NUMBER_ERROR_MESSAGE = "로또 당첨번호는 6개가 필요합니다.";
    public static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 번호와 당첨 번호가 중복됩니다";
    private final ArrayList<LottoNumber> numbers; //
    private final LottoNumber bonusNumber;

    public WinningNumbers(String[] winningNumbers, String bonusNumber) {
        this.numbers = makeNumbers(winningNumbers);
        this.bonusNumber = new LottoNumber(Integer.parseInt(bonusNumber));
        if (isDuplicatedNumber()) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicatedNumber() {
        return numbers.contains(this.bonusNumber);
    }

    private ArrayList<LottoNumber> makeNumbers(String[] numbers) {
        ArrayList<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toCollection(ArrayList::new));

        if (!isValidTicketSize(lottoNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBER_ERROR_MESSAGE);
        }
        return lottoNumbers;
    }

    private boolean isValidTicketSize(ArrayList<LottoNumber> lottoNumbers) {
        return new HashSet<>(lottoNumbers).size() == 6;
    }

    public int getSize() {
        return numbers.size();
    }

    public LottoNumber getNumberOfIndex(int index) {
        return numbers.get(index);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
