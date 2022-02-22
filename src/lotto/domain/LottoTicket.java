package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;
    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generateRandomLottoNumbers();
    }

    public LottoTicket(int[] winningNumber) {
        this.lottoNumbers = parseWinningNumber(winningNumber);
    }

    private List<Integer> generateRandomLottoNumbers() {
        return new ArrayList<>();
    }

    private List<Integer> parseWinningNumber(int[] winningNumber) {
        return new ArrayList<>();
    }
}
