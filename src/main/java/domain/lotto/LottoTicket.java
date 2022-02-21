package domain.lotto;

public class LottoTicket {
    private LottoNumbers lottoNumbers;

    private LottoTicket() {
    }

    public static LottoTicket create() {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.lottoNumbers = new LottoNumbers();

        return lottoTicket;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
