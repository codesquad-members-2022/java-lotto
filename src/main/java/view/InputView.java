package view;

import domain.Ball;
import domain.Lotto;
import domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String HOW_MUCH_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String COUNT_OF_SELF_LOTTO_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String SELF_NUMMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static User askHowManyLottos() {
        System.out.println(HOW_MUCH_MONEY_MESSAGE);
        int money = Integer.parseInt(sc.nextLine());
        System.out.println(COUNT_OF_SELF_LOTTO_MESSAGE);
        int countOfSelf = Integer.parseInt(sc.nextLine());
        return new User(money, countOfSelf);
    }

    public static Lotto createWinningLotto() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return createLotto();
    }

    public static Lotto inputSelfLotto() {
        System.out.println(SELF_NUMMBER_MESSAGE);
        return createLotto();
    }

    public static void close() {
        sc.close();
    }

    public static Ball getBonusBall() {
        System.out.println(BONUS_BALL_MESSAGE);
        int bonusNumber = Integer.parseInt(sc.nextLine());
        System.out.println();
        return new Ball(bonusNumber);
    }

    private static Lotto createLotto() {
        String[] numbers = sc.nextLine().replaceAll(" ","").split(",");
        System.out.println();
        List<Ball> balls = Arrays.stream(numbers)
                .map(number -> new Ball(Integer.parseInt(number)))
                .collect(Collectors.toList());
        return new Lotto(balls);
    }
}
