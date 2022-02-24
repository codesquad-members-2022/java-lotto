package domains;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningNumbersCounter {
	private final Map<Integer, Integer> counts;

	public WinningNumbersCounter(List<Integer> threeOrMore) {
		this.counts = getNumberOfEachRanks(threeOrMore);
	}

	private static Map<Integer, Integer> getNumberOfEachRanks(List<Integer> threeOrMore) {
		Map<Integer, Integer> countInfo = new LinkedHashMap<>();
		for (Integer numberOfLottos : threeOrMore) {
			countInfo.put(numberOfLottos, countInfo.getOrDefault(numberOfLottos, 0) + 1);
		}
		return countInfo;
	}

	public Map<Integer, Integer> getCounts() {
		return counts;
	}
}
