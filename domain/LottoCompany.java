package PACKAGE_NAME.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCompany {
    private static List<Integer> winningNumbers = new ArrayList<>();

    public List<Integer> getWinningNumbers(){
        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    public void notifyAnswer(List<Integer> inputWinningNumber) {
        if(winningNumbers.size() != 0){
            winningNumbers = new ArrayList<>();
        }
        winningNumbers.addAll(inputWinningNumber);
    }
}
