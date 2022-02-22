package model;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean sameList(List<Integer> lists) {
        return numbers.containsAll(lists);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean sameNumber(int checkWinNumber) {
        return numbers.contains(checkWinNumber);
    }

    public int countCollectNumber(String[] winNumbers) {
        int count = 0;
        for (String winNumber : winNumbers) {
            if(numbers.contains(Integer.parseInt(winNumber))){
                count++;
            }
        }
        return count;
    }
}
