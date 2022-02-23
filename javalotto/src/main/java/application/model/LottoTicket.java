package application.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import application.domain.Lotto;

public class LottoTicket {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 46;
    private static final int AMOUNT_LOTTO_NUMBER = 6;

    private LottoTicket() {
    }

    public static List<Lotto> makeLotto(int userPurchaseQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < userPurchaseQuantity; i++) {
            Lotto tempLotto = new Lotto(createNumbers());
            lottos.add(tempLotto);
        }
        return lottos;
    }

    private static List<Integer> createNumbers() {
        return new SecureRandom()
                .ints(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .parallel()
                .distinct()
                .limit(AMOUNT_LOTTO_NUMBER)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }
}
