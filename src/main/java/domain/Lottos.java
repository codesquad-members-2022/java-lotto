package domain;

import view.OutputView;

import java.util.*;

public class Lottos {
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos = new ArrayList<>();

    public void createLotto(int purchasePrice) {
        List<Integer> lottoBalls = createLottoBalls();
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

    public Map<Rank, Integer> checkWiningNumber(int[] winingNumber, int bonusNumber) {
        Map<Rank, Integer> numberOfWins = createNumberOfWinsMap();

        for (Lotto lotto : lottos) {
            int matchedCount = lotto.check(winingNumber);
            boolean isMatchBonusNumber = lotto.isMatchBonusNumber(bonusNumber);

            Rank rank = Rank.checkRank(matchedCount, isMatchBonusNumber);
            if (numberOfWins.containsKey(rank)) {
                numberOfWins.put(rank, numberOfWins.get(rank) + 1);
            }
        }
        return numberOfWins;
    }

    private Map<Rank, Integer> createNumberOfWinsMap() {
        Map<Rank, Integer> numberOfWins = new EnumMap<>(Rank.class);
        numberOfWins.put(Rank.FIFTH, 0);
        numberOfWins.put(Rank.FOURTH, 0);
        numberOfWins.put(Rank.THIRD, 0);
        numberOfWins.put(Rank.SECOND, 0);
        numberOfWins.put(Rank.FIRST, 0);
        return numberOfWins;
    }

    public double calculateRateBenefit(Map<Rank, Integer> winingResult, int money) {
        double benefit = 0;

        Set<Rank> ranks = winingResult.keySet();

        for (Rank rank : ranks) {
            benefit += rank.getWinningMoney() * winingResult.get(rank);
        }

        return ((benefit / money) - 1) * 100;
    }

    private List<Integer> createLottoBalls() {
        List<Integer> lottoBalls = new ArrayList<>();

        for (int lottoBall = LOTTO_FIRST_NUMBER; lottoBall <= LOTTO_LAST_NUMBER; lottoBall++) {
            lottoBalls.add(lottoBall);
        }

        return lottoBalls;
    }


}
