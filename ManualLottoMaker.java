import java.util.ArrayList;
import java.util.List;

public class ManualLottoMaker extends LottoMaker {

    private static final String SEPARATOR = ",\\s|,|\\s";
    private List<String> manualLottoList;
    private int manualLottoIndex = 0;

    public ManualLottoMaker(List<String> manualLottoList) {
        this.manualLottoList = manualLottoList;
    }

    @Override
    public List<Lotto> getLottoList(int countOfManualLotto) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < countOfManualLotto; i++) {
            manualLottoIndex = i;
            list.add(new Lotto(makeLottoNumber()));
        }

        return list;
    }

    @Override
    protected List<Integer> makeLottoNumber() {
        List<Integer> numberList = new ArrayList<>();

        String[] numbers = manualLottoList.get(manualLottoIndex).split(SEPARATOR);
        for (int i = 0; i < 6; i++) {
            numberList.add(Integer.parseInt(numbers[i]));
        }

        return numberList;
    }
}
