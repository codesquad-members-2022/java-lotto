package view.output;

import domain.lotto.LottoNumber;
import domain.lotto.LottoTicket;
import domain.lotto.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottoTickets(LottoTickets lottoTickets) {
        List<LottoTicket> tickets = lottoTickets.getLottoTickets();
        System.out.printf("%d개를 구매했습니다.\n", tickets.size());
        System.out.println(makeLottoTicketsString(tickets));
    }

    private static String makeLottoTicketsString(List<LottoTicket> tickets) {
        return tickets.stream()
                .map(OutputView::makeLottoTicketString)
                .collect(Collectors.joining("\n"));
    }

    private static String makeLottoTicketString(LottoTicket lottoTicket) {
        return lottoTicket.getLottoNumbers().stream()
                .mapToInt(LottoNumber::getNumber)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
