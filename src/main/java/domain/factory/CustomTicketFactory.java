package domain.factory;

import domain.LottoNumber;
import domain.LottoTicket;

import java.util.ArrayList;

public class CustomTicketFactory implements TicketFactory {
    @Override
    public LottoTicket generateTicket(ArrayList<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }
}
