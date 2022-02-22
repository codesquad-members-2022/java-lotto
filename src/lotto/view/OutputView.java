package lotto.view;

import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

import java.util.stream.IntStream;

public class OutputView {
    public void printPurchaseResult(LottoBundle lottoBundle) {
        System.out.printf("%d장 구매했습니다. 복권은 소액으로 건전하게 즐기세요.%n", lottoBundle.count());
        IntStream.range(0, lottoBundle.count())
                .mapToObj(lottoBundle::getTicket)
                .map(LottoTicket::toString)
                .forEach(System.out::println);
    }

    public void printLottoResult(LottoResult lottoResult) {

    }
}
