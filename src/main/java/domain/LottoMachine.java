package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int BALL_COUNT = 6;
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());

    public static Lotto createRandomLotto() {
        Collections.shuffle(lottoNumbers);
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < BALL_COUNT; i++) {
            balls.add(new Ball(lottoNumbers.get(i)));
        }
        return new Lotto(balls);
    }

}
