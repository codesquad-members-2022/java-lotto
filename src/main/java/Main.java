import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");

        int money = scanner.nextInt();

        LottoGame lottoGame = new LottoGame(money);

        lottoGame.start(scanner);
    }

}
