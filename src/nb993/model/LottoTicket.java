package nb993.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    }

    public String toString() {
        return lottoNumbers.toString();
    }

    public Rank getResult(WinningNumber winningNumber) {
        int correctNum = 0;
        boolean hasBonus = false;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (lottoNumbers.contains(winningNumber.getNumber(i))) {
                correctNum++;
            }

            if (lottoNumbers.contains(winningNumber.getBonusNumber())) {
                hasBonus = true;
            }
        }

        return Rank.valueOf(correctNum, hasBonus);
    }
}