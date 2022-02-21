package app.lotto;

import app.lotto.view.InputView;
import app.lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int amount = inputView.readAmount();
        int lottoCount = getLottoCount(amount);
        List<List<Integer>> allShuffledNumbers = getAllShuffledNumbers(lottoCount);
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        OutputView.winStatistics(allShuffledNumbers, winningNumbers);
    }

    private static int getLottoCount(int amount) {
        return amount / 1000;
    }

    private static List<Integer> getShuffledNumbers() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(1,45)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumbers);

        List<Integer> shuffledNumbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            shuffledNumbers.add(lottoNumbers.get(i));
        }

        return shuffledNumbers;
    }

    private static List<List<Integer>> getAllShuffledNumbers(int lottoCount) {
        List<List<Integer>> allShuffledNumbers = new ArrayList<>();
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> shuffledNumbers = getShuffledNumbers();
            allShuffledNumbers.add(shuffledNumbers);
            System.out.println(shuffledNumbers);
        }

        return allShuffledNumbers;
    }
}
