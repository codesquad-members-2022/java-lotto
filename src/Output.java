import java.util.List;

public class Output {

    private Output() {}
    public static void printLottoNum(int numOfLotto, List<Lotto> lottos) {
        System.out.println(numOfLotto + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
