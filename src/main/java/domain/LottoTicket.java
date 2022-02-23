package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    List<LottoSheet> lottoSheets = new ArrayList<>();

    public void insertIntoLottoSheets(LottoSheet lottoSheet) {
        lottoSheets.add(lottoSheet);
    }

    public List<LottoSheet> getLottoSheets() {
        return lottoSheets;
    }
}
