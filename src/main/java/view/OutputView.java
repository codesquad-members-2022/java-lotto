package view;

import java.util.Map;

public class OutputView {
    public static void requestPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestWinNumber() {
        System.out.println("당첨번호를 입력해 주세요.");
    }

    public static void printResult(Map<Integer, Integer> map, String result) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

    }
}
