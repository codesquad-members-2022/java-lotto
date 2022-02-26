package domains.user;

import java.util.ArrayList;
import java.util.List;

public class Tickets {
	private List<List<Integer>> totalLottos = new ArrayList<>();

	public Tickets() {
		this.totalLottos = new ArrayList<>();
	}

	public void takeIt(List<Integer> lottoNumbers) {
		this.totalLottos.add(lottoNumbers);
	}

	public List<List<Integer>> getTotalLottos() {
		return totalLottos;
	}
}
