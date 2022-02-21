package view;

import domain.Lotto;
import java.util.List;

public class OutputView {

    public void printLotteries(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (Lotto lottery : lotteries) {
            System.out.println(lottery.getLottoNumbers());
        }
    }
}
