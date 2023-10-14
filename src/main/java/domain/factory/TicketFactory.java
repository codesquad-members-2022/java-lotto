package domain.factory;

import domain.LottoNumber;
import domain.LottoTicket;

import java.util.List;

public interface TicketFactory {
    LottoTicket generateTicket(List<LottoNumber> lottoNumbers);
}
