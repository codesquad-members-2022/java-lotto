package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketIssuer {

    private static List<LottoSheet> lottoTicket;

    static {
        lottoTicket = new ArrayList<>();
    }

    public static void issue(int purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            LottoSheet lottoSheet = new LottoSheet(LottoGenerator.getNumbers());
            lottoTicket.add(lottoSheet);
        }
    }

    public static List<LottoSheet> getLottoTicket(int purchaseQuantity) {
        issue(purchaseQuantity);
        return lottoTicket;
    }
}
