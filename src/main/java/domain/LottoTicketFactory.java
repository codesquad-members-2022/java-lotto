package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoTicketFactory {

    private LottoTicketFactory() {
    }

    public static LottoTicket generateCustomTicket(ArrayList<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }


    public static LottoTicket generateRandomTicket() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(new LottoNumber(randomRangeInt(1, 45)));
        }
        return new LottoTicket(new ArrayList<>(lottoNumbers));
    }

    private static int randomRangeInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
