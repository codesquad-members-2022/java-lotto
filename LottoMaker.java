import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    private static final String SEPARATOR = ",\\s|,|\\s";

    public List<Integer> makeManualLotto(String manualLottoNumber) {
        return processManualLottoNumber(manualLottoNumber);
    }

    public List<Integer> makeAutoLotto() {
        return processAutoLottoNumber(initNumbers());
    }

    private List<Integer> initNumbers() {
        List<Integer> totalNumberList = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            totalNumberList.add(i);
        }

        return totalNumberList;
    }

    private List<Integer> processManualLottoNumber(String manualLottoNumber) {
        List<Integer> numberList = new ArrayList<>();

        String[] numbers = manualLottoNumber.strip().split(SEPARATOR);
        for (int i = 0; i < 6; i++) {
            numberList.add(Integer.parseInt(numbers[i]));
        }

        return numberList;
    }

    private List<Integer> processAutoLottoNumber(List<Integer> totalNumberList) {
        Collections.shuffle(totalNumberList);
        List<Integer> lottoNumberList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            lottoNumberList.add(totalNumberList.get(i));
        }
        Collections.sort(lottoNumberList);

        return lottoNumberList;
    }
}
