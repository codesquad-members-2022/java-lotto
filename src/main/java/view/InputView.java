package view;

import domain.User;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static User askHowManyLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();
        return new User(money);
    }

}
