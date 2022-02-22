package view;

import model.ValueMap;

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

        for (Integer key : map.keySet()) {
            System.out.println(key + "개 일치 (" + ValueMap.valueMap.get(key) + "원) - " + map.get(key) + "개");
        }
        System.out.println("총 수익률은 " + result + "%입니다.");
    }
}
