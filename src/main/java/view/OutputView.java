package view;

import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구입했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> ballNumbers = lotto.getBallNumbers();
            String lottoString = getLottoString(ballNumbers);
            System.out.println(lottoString);
        }
    }

    private static String getLottoString(List<Integer> ballNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        List<String> stringBallNumbers = ballNumbers.stream().map(String::valueOf).collect(Collectors.toList());
        sb.append(String.join(", ", stringBallNumbers));
        sb.append("]");
        return sb.toString();
    }

}
