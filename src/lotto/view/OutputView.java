package lotto.view;

import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.PrizeDivision;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OutputView {
    public void printPurchaseResult(LottoBundle lottoBundle) {
        System.out.printf("수동으로 %d장, 자동으로 %d장 구매했습니다. 복권은 소액으로 건전하게 즐기세요.%n",
                lottoBundle.getManualTicketCount(), lottoBundle.getAutoTicketCount());
        IntStream.range(0, lottoBundle.count())
                .mapToObj(lottoBundle::getTicket)
                .map(LottoTicket::toString)
                .forEach(System.out::println);
        System.out.println();
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("-------");
        Stream.of(PrizeDivision.values())
                .map(d -> d.toString() + String.format(" - %d장", lottoResult.getWinnerCount(d)))
                .forEach(System.out::println);
        System.out.printf("총 수익률은 %,4.2f%%입니다.%n", lottoResult.getProfitRate());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
