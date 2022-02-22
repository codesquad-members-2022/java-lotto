import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");

        int money = scanner.nextInt();

        int count = money / 1000;

        System.out.println(count + "개를 구매하셨습니다.");

        LottoGame lottoGame = new LottoGame(count);

        lottoGame.start(scanner);
    }

}
