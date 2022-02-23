package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoTicketFactory {
    private static final int NORMAL_TICKET_SIZE = 6;
    private static final int LOWER_BOUND_NUMBER = 1;
    private static final int UPPER_BOUND_NUMBER = 45;

    private LottoTicketFactory() {
    }

    public static LottoTicket generateCustomTicket(ArrayList<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket generateRandomTicket() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < NORMAL_TICKET_SIZE) {
            lottoNumbers.add(new LottoNumber(randomRangeInt(LOWER_BOUND_NUMBER, UPPER_BOUND_NUMBER)));
        }
        return new LottoTicket(new ArrayList<>(lottoNumbers));
    }

    private static int randomRangeInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
