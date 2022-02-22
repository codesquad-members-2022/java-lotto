import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    public List<Integer> autoMakeLotto() {
        return selectNumbers(initNumbers());
    }

    private List<Integer> initNumbers() {
        List<Integer> totalNumberList = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            totalNumberList.add(i);
        }

        return totalNumberList;
    }

    private List<Integer> selectNumbers(List<Integer> totalNumberList) {
        Collections.shuffle(totalNumberList);
        List<Integer> lottoNumberList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            lottoNumberList.add(totalNumberList.get(i));
        }
        Collections.sort(lottoNumberList);

        return lottoNumberList;
    }
}
