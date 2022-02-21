import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");

        int money = scanner.nextInt();

        int count = money / 1000;

        System.out.println(count + "개를 구매하셨습니다.");

        List<Integer> lottoBalls = new ArrayList<>();

        for (int lottoBall = 1; lottoBall <= 45; lottoBall++) {
            lottoBalls.add(lottoBall);
        }

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Collections.shuffle(lottoBalls);
            ArrayList<Integer> al = new ArrayList<>(lottoBalls.subList(0,6));
            lottos.add(new Lotto(al));
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

    }

}
