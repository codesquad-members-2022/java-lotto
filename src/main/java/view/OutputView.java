package view;

import model.CollectCalculator;
import model.Lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void requestPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestWinNumber() {
        System.out.println("지난 주 당첨번호를 입력해 주세요.");
    }

    public static void printResult(Map<Integer, Integer> map, String result) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        for (Integer key : map.keySet()) {
            System.out.println(key + "개 일치 (" + CollectCalculator.getWinnerMoney(key) + "원) - " + map.get(key) + "개");
        }
        System.out.println("총 수익률은 " + result + "%입니다.");
    }

    public static void printPurchaseCount(int count, List<Lotto> lottoList) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            String collect = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(collect);
        }
    }

    public static void requestBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
    }
}
