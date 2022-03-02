package nb993.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nb993.util.LottoUtil;

public class LottoTicket {

    public static final int PRICE = 1000;

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        List<Integer> possibleNumbers = new ArrayList<>(45);
        for (int i = 0; i < 45; i++) {
            possibleNumbers.add(i + 1);
        }
        Collections.shuffle(possibleNumbers);
        lottoNumbers = new ArrayList<>(possibleNumbers.subList(0, LOTTO_NUMBERS_SIZE));
        Collections.sort(lottoNumbers);
    }

    public LottoTicket(List<Integer> numbers) {
        LottoUtil.validate(numbers);
        Collections.sort(numbers);
        lottoNumbers = numbers;
    }

    public String toString() {
        return lottoNumbers.toString();
    }

    public Rank getResult(WinningNumber winningNumber) {
        int correctCount = getCorrectCount(winningNumber);
        boolean hasBonus = hasBonusNumber(winningNumber);

        return Rank.valueOf(correctCount, hasBonus);
    }

    private boolean hasBonusNumber(WinningNumber winningNumber) {
        return lottoNumbers.contains(winningNumber.getBonusNumber());
    }

    private int getCorrectCount(WinningNumber winningNumber) {
        int correctCount = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            correctCount += lottoNumbers.contains(winningNumber.getNumber(i)) ? 1 : 0;
        }
        return correctCount;
    }
}
