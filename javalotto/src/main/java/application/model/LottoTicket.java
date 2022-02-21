package application.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import application.domain.Lotto;
import application.view.InputView;
import application.view.OutputView;

public class LottoTicket {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int AMOUNT_LOTTO_NUMBER = 6;

    public void init() {
        int userPurchaseAmount = InputView.getPurchaseAmount();
        int userPurchaseQuantity = userPurchaseAmount / 1000;
        OutputView.printPurchaseQuantity(userPurchaseQuantity);
        for (int i = 0; i < userPurchaseQuantity; i++) {
            Lotto tempLotto = new Lotto(createNumbers());
            OutputView.printLottoNumbers(tempLotto.getNumbers());
        }
        List<Integer> userWinningNumber = InputView.getWinningNumber();
    }

    private List<Integer> createNumbers() {
        return new Random(System.currentTimeMillis())
                .ints(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .distinct()
                .limit(AMOUNT_LOTTO_NUMBER)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }
}
