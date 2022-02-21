package nb993.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static List<Integer> lottoList;
    private List<Integer> numbers;

    static {
        lottoList = new ArrayList<>(45);
        for (int i = 0; i < 45; i++) {
            lottoList.add(i + 1);
        }
    }

    public Lotto() {
        Collections.shuffle(lottoList);
        numbers = new ArrayList<>(lottoList.subList(0, 6));
    }

    public String toString() {
        return numbers.toString();
    }

    public int getResult(int[] winningNumbers) {
        int correctNum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.contains(winningNumbers[i])) {
                correctNum++;
            }
        }

        return correctNum;
    }
}