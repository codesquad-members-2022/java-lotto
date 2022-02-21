import static views.Input.*;
import static views.Output.*;

import java.util.ArrayList;
import java.util.Collections;

import domains.Lotto;

public class Main {
	public static void main(String[] args) {
		println.accept("구입금액을 입력해 주세요.");
		int purchaseAmount = nextInt();

		int ticketAccount = purchaseAmount / 1000;
		println.accept(ticketAccount+"개를 구매했습니다.");


		ArrayList<Integer> lottoNumbers = new ArrayList<>();
		for (int i = 1; i < 46; i++) {
			lottoNumbers.add(i);
		}
		mixNumber(lottoNumbers);



		prints.accept(lottoNumbers);

		scanClose();
	}

	private static void mixNumber(ArrayList<Integer> lottoNumbers) {
		Collections.shuffle(lottoNumbers);
	}
}
