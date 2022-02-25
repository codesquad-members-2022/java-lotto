package application.view;

import application.domain.Prize;
import application.domain.Statistics;
import application.domain.UserLottery;
import java.util.List;
import java.util.Map;

@Deprecated
public class OutputView {
    private static OutputView outputView;

    private OutputView() {}

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printCount(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public void printLotteries(List<UserLottery> lotteries) {
        lotteries.stream()
                .map(UserLottery::getNumbers)
                .forEach(System.out::println);
    }

    public void printEarningsRate(double earningsRate) {
        System.out.printf("총 수익률은 %.2f%% 입니다.%n", earningsRate * 100);
    }

    public void printStatistics(Statistics statistics) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator())
            .append("당첨 통계").append(System.lineSeparator())
            .append("---------").append(System.lineSeparator());

        Map<Prize, Integer> counts = statistics.getCounts();

        counts.keySet().forEach(key ->
            sb.append(key.getResult().getMatchCount()).append("개 일치")
                .append(key.getResult().getBonus() != null &&
                        key.getResult().getBonus() ? ", 보너스 볼 일치(" : " (")
                .append(key.getReward()).append("원) - ")
                .append(counts.get(key)).append("개")
                .append(System.lineSeparator()));

        System.out.println(sb);
    }
}
