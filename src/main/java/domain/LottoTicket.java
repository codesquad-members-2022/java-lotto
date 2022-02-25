package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private List<LottoSheet> lottoTicket;

    public LottoTicket() {
        lottoTicket = new ArrayList<>();
    }

    public void addManualSheets(List<LottoSheet> manualSheets) {
        lottoTicket.addAll(manualSheets);
    }

    public void issue(int purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            LottoSheet lottoSheet = new LottoSheet(LottoGenerator.getShuffledNumbers());
            lottoTicket.add(lottoSheet);
        }
    }

    public List<LottoSheet> getLottoTicket() {
        return lottoTicket;
    }
}
