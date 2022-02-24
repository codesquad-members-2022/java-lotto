package domain.factory;

import domain.LottoNumber;
import domain.LottoTicket;

import java.util.ArrayList;

public interface TicketFactory {
    LottoTicket generateTicket(ArrayList<LottoNumber> lottoNumbers);
}
