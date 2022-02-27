package domain.factory;

import domain.LottoNumber;
import domain.LottoTicket;

import java.util.List;

public class CustomTicketFactory implements TicketFactory {
    @Override
    public LottoTicket generateTicket(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }
}
