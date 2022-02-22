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
    private static final int LOTT_TICKET_PRICE = 1000;

    public void init() {
        List<Lotto> lottos = makeLotto();
        List<Integer> userWinningNumber = InputView.getWinningNumber();
        int[] counts = makeStatistics(lottos, userWinningNumber);
        OutputView.printWinningStatistics(counts);
    }

    private int[] makeStatistics(List<Lotto> lottos, List<Integer> userWinningNumber) {
        return null;
    }

    private List<Lotto> makeLotto() {
        List<Lotto> lottos = new ArrayList<>();
        int userPurchaseAmount = InputView.getPurchaseAmount();
        int userPurchaseQuantity = userPurchaseAmount / LOTT_TICKET_PRICE;
        OutputView.printPurchaseQuantity(userPurchaseQuantity);
        for (int i = 0; i < userPurchaseQuantity; i++) {
            Lotto tempLotto = new Lotto(createNumbers());
            lottos.add(tempLotto);
            OutputView.printLottoNumbers(tempLotto.getNumbers());
        }
        return lottos;
    }

    private List<Integer> createNumbers() {
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
