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

    public static User askHowManyLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(sc.nextLine());
        return new User(money);
    }

    public static Lotto createWinningLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] numbers = sc.nextLine().split(", ");
        List<Ball> balls = Arrays.stream(numbers)
                .map(number -> new Ball(Integer.parseInt(number)))
                .collect(Collectors.toList());
        return new Lotto(balls);
    }
}
