package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;
    private LottoCalculator lottoCalculator;

    public LottoGame() {
        lottos = new ArrayList<>();
        lottoCalculator = new LottoCalculator();
    }

    public void start(int money) {
        int count = money / 1000;

        System.out.println(count + "개를 구매하셨습니다.");
        createLotto(count, createLottoBalls());

        print();

        String[] split = InputView.winningNumber().split(", ");

        int[] winingNumber = new int[6];

        for (int index = 0; index < winingNumber.length; index++) {
            winingNumber[index] = Integer.parseInt(split[index]);
        }

        lottoCalculator.operate(lottos, winingNumber, money);
    }

    private List<Integer> createLottoBalls() {
        List<Integer> lottoBalls = new ArrayList<>();

        for (int lottoBall = 1; lottoBall <= 45; lottoBall++) {
            lottoBalls.add(lottoBall);
        }
        return lottoBalls;
    }

    private void createLotto(int count, List<Integer> lottoBalls) {
        for (int i = 0; i < count; i++) {
            Collections.shuffle(lottoBalls);
            ArrayList<Integer> lottoNumbers = new ArrayList<>(lottoBalls.subList(0, 6));
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public void print() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }


}
