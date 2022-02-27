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
            String tempValue = makeResultTemplate(key);
            System.out.println(tempValue + CollectCalculator.getWinningMoney(key) + "원) - " + map.get(key) + "개");
        }
        System.out.println("총 수익률은 " + result + "%입니다.");
    }

    private static String makeResultTemplate(Integer key) {
        if (key == 7) {
            return "5개 일치, 보너스 볼 일치 (";
        }
        return key + "개 일치 (";
    }

    public static void printPurchaseCount(int count, int manualLottoEach, List<Lotto> lottoList) {
        int autoLottoEach = count - manualLottoEach;
        System.out.println("수동으로 " + manualLottoEach + "장, "+ "자동으로 " + autoLottoEach + "장을 구매했습니다.");
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

    public static void requestManual() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void requestManualLottoNumber() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printSentence(String sentence) {
        System.out.println(sentence);
    }
}
