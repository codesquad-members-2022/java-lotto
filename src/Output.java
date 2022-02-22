import static java.lang.System.lineSeparator;

import java.util.List;
import java.util.Map;

public class Output {

    private static final StringBuilder sb = new StringBuilder();

    private Output() {}

    public static void printLottoNum(List<Lotto> lotteries) {
        sb.append(lotteries.size()).append("개를 구매했습니다.").append(lineSeparator());
        for (Lotto lottery : lotteries) {
            sb.append(lottery.getNumbers()).append(lineSeparator());
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    public static void printResult(Map<Rank, Integer> map, double earningRate) {
        sb.append("당첨 통계")
            .append(lineSeparator())
            .append("----------")
            .append(lineSeparator());

        appendMatchedInfo(map, earningRate);
        System.out.println(sb);
        sb.setLength(0);
    }

    private static void appendMatchedInfo(Map<Rank, Integer> map, double earningRate) {

        for (Rank rank : map.keySet()) {
            sb.append(rank.getCountOfMatch())
                .append("개 일치 (")
                .append(rank.getWinningMoney())
                .append(")-")
                .append(map.getOrDefault(rank, 0))
                .append(lineSeparator());
        }
        sb.append("수익률은 ").append(earningRate).append("%");
    }

}
