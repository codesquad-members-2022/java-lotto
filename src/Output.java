import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Output {

    private Output() {
    }

    public static void printLottoNum(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Map<Rank, Integer> rankResult, int total,
        Collection<Integer> values) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        System.out.println(
            "3개 일치 (" + Rank.FIFTH.getWinningMoney() + ")" + "-" + rankResult.getOrDefault(
                Rank.FIFTH, 0));
        System.out.println(
            "4개 일치 (" + Rank.THIRD.getWinningMoney() + ")" + "-" + rankResult.getOrDefault(
                Rank.THIRD, 0));
        System.out.println(
            "5개 일치 (" + Rank.SECOND.getWinningMoney() + ")" + "-" + rankResult.getOrDefault(
                Rank.SECOND,
                0));
        System.out.println(
            "6개 일치 (" + Rank.FIRST.getWinningMoney() + ")" + "-" + rankResult.getOrDefault(
                Rank.FIRST, 0));

        System.out.println(
            (double) ((total - values.size() * 1000) / (values.size() * 1000)) * 100 + "%");

    }
}
