import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoGame {

    private List<Lotto> lottos;

    public LottoGame(int count) {
        lottos = new ArrayList<>();
        createLotto(count, createLottoBalls());
    }

    public void start(Scanner scanner) {
        print();
        System.out.println("당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        String[] split = scanner.nextLine().split(", ");

        int[] winingNumber = new int[6];

        for (int i = 0; i < winingNumber.length; i++) {
            winingNumber[i] = Integer.parseInt(split[i]);
        }

        int[] result = new int[7];

        for (Lotto lotto : lottos) {
            int rank = lotto.check(winingNumber);
            result[rank]++;
        }
    }

    private List<Integer> createLottoBalls() {
        List<Integer> lottoBalls = new ArrayList<>();

        for (int lottoBall = 1; lottoBall <= 45; lottoBall++) {
            lottoBalls.add(lottoBall);
        }
        return lottoBalls;
    }

    private void createLotto(int count, List<Integer> lottoBalls) {
        for (int i = 0; i < count; i++) {
            Collections.shuffle(lottoBalls);
            ArrayList<Integer> al = new ArrayList<>(lottoBalls.subList(0,6));
            lottos.add(new Lotto(al));
        }
    }

    public void print() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
