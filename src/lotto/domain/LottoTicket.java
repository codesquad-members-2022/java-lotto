package lotto.domain;

import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new LottoNumbers().generateRandomLottoNumbers();
    }

    public LottoTicket(int[] numbers) {
        this.lottoNumbers = LottoNumbers.parseNumbers(numbers);
    }

    public int matchNumbers(LottoTicket anotherTicket) {
        return lottoNumbers.stream()
                .map(anotherTicket::contains)
                .mapToInt(b -> b ? 1 : 0)
                .sum();
    }
    
    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
