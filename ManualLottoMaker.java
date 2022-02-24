import java.util.ArrayList;
import java.util.List;

public class ManualLottoMaker implements LottoMaker {

    private static final String SEPARATOR = ",\\s|,|\\s";
    private List<String> manualLottoList;

    public ManualLottoMaker(List<String> manualLottoList) {
        this.manualLottoList = manualLottoList;
    }

    @Override
    public List<Lotto> getLottoList(int countOfManualLotto) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < countOfManualLotto; i++) {
            list.add(new Lotto(makeLottoNumber(manualLottoList.get(i))));
        }

        return list;
    }

    private List<Integer> makeLottoNumber(String manualLottoNumber) {
        List<Integer> numberList = new ArrayList<>();

        String[] numbers = manualLottoNumber.split(SEPARATOR);
        for (int i = 0; i < 6; i++) {
            numberList.add(Integer.parseInt(numbers[i]));
        }

        return numberList;
    }
}
