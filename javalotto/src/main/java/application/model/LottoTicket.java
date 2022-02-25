package application.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import application.domain.Lotto;
import application.view.InputView;
import application.view.OutputView;

public class LottoTicket {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 46;
    private static final int AMOUNT_LOTTO_NUMBER = 6;

    private LottoTicket() {
    }

    public static List<Lotto> makeAutoLotto(int userPurchaseQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < userPurchaseQuantity; i++) {
            Lotto tempLotto = new Lotto(createNumbers());
            lottos.add(tempLotto);
        }
        return lottos;
    }

    public static List<Lotto> makeManualLotto(int userPurchaseQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        OutputView.printPleaseEnterYourManualNumbers();
        InputView.removeNewLine();
        for (int i = 0; i < userPurchaseQuantity; i++) {
            lottos.add(new Lotto(InputView.getManualLotto()));
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
