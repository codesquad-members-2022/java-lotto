package PACKAGE_NAME.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;

public class LottoStore {

    private static final List<LottoNumber> lottoNumbers;
    private static final int START_INDEX = 0;
    private static final int SIX = 6;
    private static final int START = 1;
    private static final int END = 45;
    private static final int TICKET_PER_PRICE = 1000;

    static {
        lottoNumbers = IntStream.rangeClosed(START, END)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        shuffle();
        return getSixNumbers();
    }

    private void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    private List<LottoNumber> getSixNumbers() {
        return new ArrayList<>(lottoNumbers.stream()
                .limit(SIX)
                .sorted(comparing(LottoNumber::getValue))
                .collect(Collectors.toUnmodifiableList()));
    }

    public List<LottoTicket> getLottoTickets(Money money) {
        int ticketCount = getTicketCount(money);
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int index = START_INDEX; index < ticketCount; index++) {
            lottoTickets.add(new LottoTicket(getLottoNumbers()));
        }
        return lottoTickets;
    }

    private int getTicketCount(Money money){
        return money.getValue() / TICKET_PER_PRICE;
    }
}
