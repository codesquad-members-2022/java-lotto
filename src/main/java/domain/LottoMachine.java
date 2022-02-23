package domain;

import view.InputView;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int BALL_COUNT = 6;
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public static void sellLotto(User user) {
        createSelfLottos(user);
        createRandomLottos(user);
    }

    private static void createSelfLottos(User user) {
        for (int i = 0; i < user.getCountOfSelf(); i++) {
            Lotto lotto = InputView.inputSelfLotto();
            user.buyLotto(lotto);
        }
    }

    private static void createRandomLottos(User user) {
        for (int i = 0; i < user.getCountOfAuto(); i++) {
            user.buyLotto(createRandomLotto());
        }
    }

    private static Lotto createRandomLotto() {
        Collections.shuffle(lottoNumbers);
        Set<Ball> balls = lottoNumbers.stream()
                .limit(BALL_COUNT)
                .map(Ball::new)
                .collect(Collectors.toSet());
        return new Lotto(balls);
    }
}
