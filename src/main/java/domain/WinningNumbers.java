package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 숫자는 6개가 필요합니다.";
    private final ArrayList<LottoNumber> numbers; //
    private final LottoNumber bonusNumber;

    public WinningNumbers(String[] winningNumbers, String bonusNumber) {
        this.numbers = makeNumbers(winningNumbers);
        this.bonusNumber = new LottoNumber(Integer.parseInt(bonusNumber));
    }

    private ArrayList<LottoNumber> makeNumbers(String[] numbers) {
        ArrayList<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toCollection(ArrayList::new));

        if (!isValidTicketSize(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
        return lottoNumbers;
    }

    private boolean isValidTicketSize(ArrayList<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() == 6;
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
