package model;

import view.InputView;
import view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private int price;
    private static final int LOTTO_PRICE = 1000;
    private int count;
    private List<Lotto> lottoList = new ArrayList<>();
    private List<Integer> range = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private static Map<Integer, Integer> map = new HashMap<>();
    // key : 3, 4, 5, 6
    // value : 3? 4? 5? 6?

    static {
        map.put(3,0);
        map.put(4,0);
        map.put(5,0);
        map.put(6,0);
    }

    public void buildLotto() {
        price = Integer.parseInt(InputView.requestPrice());
        count = price / LOTTO_PRICE;

        while (lottoList.size() != count) {
            Set<Integer> numbers = new HashSet<>();
            while (numbers.size() != 6) {
                Collections.shuffle(range);
                numbers.add(range.get(0));
            }
            List<Integer> lists = new ArrayList<>(numbers);
            boolean overLapCheck = false;
            for (Lotto lotto : lottoList) {
                if (lotto.sameList(lists)) {
                    overLapCheck = true;
                    break;
                }
            }
            if (!overLapCheck) {
                Collections.sort(lists);
                lottoList.add(new Lotto(lists));
            }
        }
        //Test
        for (Lotto lotto : lottoList) {
            for (Integer number : lotto.getNumbers()) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }



    public void checkWinNumber() {
        String winNumber = InputView.requestWinNumber();
        String[] winNumbers = winNumber.split(", "); // 1,2,3,4,5,6

        for (Lotto lotto : lottoList) {
            int count = lotto.countCollectNumber(winNumbers);
            if(count >= 3){
                map.put(count,map.get(count)+1);
            }
        }
        //Test
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            Integer integer1 = map.get(integer);
            System.out.println(integer1);
        }

    }
}

