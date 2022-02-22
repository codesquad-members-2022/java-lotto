package PACKAGE_NAME.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCompany {
    private static final List<Integer> winningNumbers = new ArrayList<>();

    public List<Integer> getWinningNumbers(){
        Collections.sort(winningNumbers);
        return winningNumbers;
    }
}
