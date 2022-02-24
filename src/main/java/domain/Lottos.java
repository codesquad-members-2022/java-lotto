package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final int RANK_MINIMAL_NUMBER = 3;

    private final List<Lotto> lottos = new ArrayList<>();

    public void createLotto(int purchasePrice, List<Integer> lottoBalls) {
        int numberOfLottoTicket = purchasePrice / LOTTO_PRICE;

        System.out.println(numberOfLottoTicket + "개를 구매하셨습니다.");

        for (int i = 0; i < numberOfLottoTicket; i++) {
            Collections.shuffle(lottoBalls);
            ArrayList<Integer> lottoNumbers = new ArrayList<>(lottoBalls.subList(0, LOTTO_SIZE));
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public void print() {
        OutputView.printLottos(lottos);
    }

    public int[] checkWiningNumber(int[] winingNumber) {
        // 로또번호가 일치한 개수와 배열 인덱스가 일치하도록 배열사이즈를 정함
        int[] numberOfWins = new int[LOTTO_SIZE + 1];

        for (Lotto lotto : lottos) {
            int rank = lotto.check(winingNumber);
            numberOfWins[rank]++;
        }

        return numberOfWins;
    }

    public double calculateRateBenefit(int[] numberOfWins, int money) {
        double benefit = 0;

        for (int index = RANK_MINIMAL_NUMBER; index < numberOfWins.length; index++) {
            benefit += Rank.getWinningMoney(index) * numberOfWins[index];
        }

        return ((benefit / money) - 1) * 100;
    }


}
