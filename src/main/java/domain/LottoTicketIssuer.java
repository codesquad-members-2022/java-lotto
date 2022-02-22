package domain;

public class LottoTicketIssuer {

    private static int purchaseQuantity;
    private LottoTicket lottoTicket;

    public LottoTicketIssuer(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
        lottoTicket = new LottoTicket();
        issue();
    }

    public void issue() {
        for (int i = 0; i < purchaseQuantity; i++) {
            LottoSheet lottoSheet = new LottoSheet(new LottoGenerator().getNumbers());
            lottoTicket.insertIntoLottoSheets(lottoSheet);
        }
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }
}
