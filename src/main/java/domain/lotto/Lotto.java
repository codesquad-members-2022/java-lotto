package domain.lotto;

public class Lotto {
    private LottoNumbers lottoNumbers;

    private Lotto() {
    }

    public static Lotto create() {
        Lotto lotto = new Lotto();
        lotto.lottoNumbers = new LottoNumbers();

        return lotto;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
