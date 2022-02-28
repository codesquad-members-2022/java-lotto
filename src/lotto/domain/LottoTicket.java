package lotto.domain;

public class LottoTicket {
    public static final int PRICE = 1000;
    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket withRandomNumbers() {
        return new LottoTicket(LottoNumberPool.getLottoNumbers());
    }

    public static LottoTicket withManualNumbers(int[] numbers) {
        return new LottoTicket(new LottoNumbers(numbers));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
