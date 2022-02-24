package view;

import domain.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String HOW_MUCH_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String COUNT_OF_CUSTOM_LOTTO_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String CUSTOM_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static User askHowManyLottos() {
        System.out.println(HOW_MUCH_MONEY_MESSAGE);
        int money = Integer.parseInt(sc.nextLine());
        System.out.println();

        System.out.println(COUNT_OF_CUSTOM_LOTTO_MESSAGE);
        int countOfCustom = Integer.parseInt(sc.nextLine());
        System.out.println();
        return new User(money, countOfCustom);
    }

    public static WinningLotto createWinningLotto() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return new WinningLotto(createLotto(), getBonusBall());
    }

    private static Ball getBonusBall() {
        System.out.println(BONUS_BALL_MESSAGE);
        int bonusNumber = Integer.parseInt(sc.nextLine());
        System.out.println();
        return new Ball(bonusNumber);
    }

    public static void close() {
        sc.close();
    }

    public static Lotto createLotto() {
        String[] numbers = sc.nextLine().replaceAll(" ","").split(",");
        Set<Ball> balls = Arrays.stream(numbers)
                .map(number -> new Ball(Integer.parseInt(number)))
                .collect(Collectors.toSet());
        return new Lotto(balls);
    }

    public static void printSellCustomLottoCount() {
        System.out.println(CUSTOM_NUMBER_MESSAGE);
    }

}
