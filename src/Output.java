import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Output {

	private Output() {
	}

	public static void printLottoNum(int numOfLotto, List<Lotto> lottos) {
		System.out.println(numOfLotto + "개를 구매했습니다.");

		for (Lotto lotto : lottos) {
			System.out.println(lotto.getNumbers());
		}
	}

	public static void printResult(Map<Lotto, Integer> result) {
		System.out.println("당첨 통계");
		System.out.println("--------");

		//todo
		// 1 -> 꽝
		// 2 -> 꽝
		// 3 -> 5000원
		// 4 -> 50000원
		// 5 -> 1500000원
		// 6 -> 20억

		Map<Rank, Integer> map = new HashMap<>();

		Collection<Integer> values = result.values();

		for (int value : values) {
			for (int i = 0; i < Rank.values().length; i++) {
				if (value == Rank.values()[i].getCountOfMatch()) {
					map.put(Rank.values()[i], map.getOrDefault(Rank.values()[i], 0) + 1);
				}
			}
		}

		int total = 0;
		total += map.getOrDefault(Rank.FIFTH, 0) * Rank.FIFTH.getWinningMoney();
		total += map.getOrDefault(Rank.THIRD, 0) * Rank.THIRD.getWinningMoney();
		total += map.getOrDefault(Rank.SECOND, 0) * Rank.SECOND.getWinningMoney();
		total += map.getOrDefault(Rank.FIRST, 0) * Rank.FIRST.getWinningMoney();

		System.out.println(
			"3개 일치 (" + Rank.FIFTH.getWinningMoney() + ")" + "-" + map.getOrDefault(Rank.FIFTH, 0));
		System.out.println(
			"4개 일치 (" + Rank.THIRD.getWinningMoney() + ")" + "-" + map.getOrDefault(Rank.THIRD, 0));
		System.out.println(
			"5개 일치 (" + Rank.SECOND.getWinningMoney() + ")" + "-" + map.getOrDefault(Rank.SECOND, 0));
		System.out.println(
			"6개 일치 (" + Rank.FIRST.getWinningMoney() + ")" + "-" + map.getOrDefault(Rank.FIRST, 0));

        System.out.println(((total - (values.size() * 1000)) / total) * 100 + "%");

	}
}
