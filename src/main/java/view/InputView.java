package view;

import domain.Lotto;
import domain.LottoMachine;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static List<Lotto> askHowMuchMoney() {
        int money = sc.nextInt();
        return LottoMachine.createLottos(money);
    }

}
