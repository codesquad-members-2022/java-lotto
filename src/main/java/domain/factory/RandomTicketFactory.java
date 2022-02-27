package domain.factory;

import domain.LottoNumber;
import domain.LottoTicket;

import java.util.*;

public class RandomTicketFactory implements TicketFactory {
    private static final int NORMAL_TICKET_SIZE = 6;
    private static final int LOWER_BOUND_NUMBER = 1;
    private static final int UPPER_BOUND_NUMBER = 45;

    private static int randomRangeInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    @Override
    public LottoTicket generateTicket(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();
        while (lottoNumberSet.size() < NORMAL_TICKET_SIZE) {
            lottoNumberSet.add(new LottoNumber(randomRangeInt(LOWER_BOUND_NUMBER, UPPER_BOUND_NUMBER)));
        }
        return new LottoTicket(new ArrayList<>(lottoNumberSet));
    }
}
