package lotto_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;
    private int fourthNumber;
    private int fifthNumber;
    private int sixthNumber;
    public Lotto() {
        List<Integer> numbers = getNumbers();
        this.firstNumber = numbers.get(0);
        this.secondNumber = numbers.get(1);
        this.thirdNumber = numbers.get(2);
        this.fourthNumber = numbers.get(3);
        this.fifthNumber = numbers.get(4);
        this.sixthNumber = numbers.get(5);
    }

    private List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> sixNumber = getNumbersToSixNumber(numbers);
        Collections.sort(sixNumber);
        return sixNumber;
    }

    private List<Integer> getNumbersToSixNumber(List<Integer> numbers) {
        List<Integer> sixNumber = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            sixNumber.add(numbers.get(i));
        }
        return sixNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

    public int getFourthNumber() {
        return fourthNumber;
    }

    public int getFifthNumber() {
        return fifthNumber;
    }

    public int getSixthNumber() {
        return sixthNumber;
    }
}
