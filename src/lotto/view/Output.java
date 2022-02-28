package lotto.view;

import static java.lang.System.lineSeparator;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class Output {

    private final StringBuilder sb = new StringBuilder();

    public void printLottoNum(List<Lotto> lotteries, int numOfMaunalLottos) {
        int numOfAutoLottos = lotteries.size() - numOfMaunalLottos;
        sb.append("수동으로 ").append(numOfMaunalLottos).append("장, ");
        sb.append("자동으로 ").append(numOfAutoLottos).append("개를 구매했습니다.").append(lineSeparator());
        for (Lotto lottery : lotteries) {
            sb.append(lottery.getNumbers()).append(lineSeparator());
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    public void printResult(Map<Rank, Integer> map, double earningRate) {
        sb.append("당첨 통계")
            .append(lineSeparator())
            .append("----------")
            .append(lineSeparator());
        appendMatchedInfo(map, earningRate);
        System.out.println(sb);
        sb.setLength(0);
    }

    private void appendMatchedInfo(Map<Rank, Integer> map, double earningRate) {
        for (Rank rank : map.keySet()) {
            boolean isSecond = Rank.isSecond(rank);
            sb.append(rank.getCountOfMatch())
                .append("개 일치")
                .append(isSecond ? ", 보너스 볼 일치" : "")
                .append("(").append(rank.getWinningMoney()).append(")-")
                .append(map.getOrDefault(rank, 0))
                .append(lineSeparator());
        }
        sb.append("총 수익률은 ").append(String.format("%.2f", earningRate)).append("%입니다.");
    }
}
