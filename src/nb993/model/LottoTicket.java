package nb993.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nb993.util.LottoUtil;

public class LottoTicket {

    private static final int LOTTO_NUMBERS_SIZE = 6;

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
        // 갯수가 6개 인지
        // 범위가 1 - 45 이내인지
        // 중복되는 숫자가 있는지 확인
        LottoUtil.validate(numbers);
        Collections.sort(numbers);
        lottoNumbers = numbers;
    }

    public String toString() {
        return lottoNumbers.toString();
    }

    public Rank getResult(WinningNumber winningNumber) {
        int correctCount = getCorrectCount(winningNumber);
        boolean hasBonus = hasBonus(winningNumber);

        return Rank.valueOf(correctCount, hasBonus);
    }

    private boolean hasBonus(WinningNumber winningNumber) {
        if (lottoNumbers.contains(winningNumber.getBonusNumber())) {
            return true;
        }

        return false;
    }

    private int getCorrectCount(WinningNumber winningNumber) {
        int correctCount = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            correctCount += lottoNumbers.contains(winningNumber.getNumber(i)) ? 1 : 0;
        }
        return correctCount;
    }
}
