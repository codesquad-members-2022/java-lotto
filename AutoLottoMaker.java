import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoMaker implements LottoMaker {

    private List<Integer> totalNumberList;

    public AutoLottoMaker() {
        totalNumberList = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            totalNumberList.add(i);
        }
    }

    @Override
    public List<Lotto> getLottoList(int countOfAutoLotto) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < countOfAutoLotto; i++) {
            list.add(new Lotto(makeLottoNumber()));
        }

        return list;
    }

    private List<Integer> makeLottoNumber() {
        Collections.shuffle(totalNumberList);
        List<Integer> lottoNumberList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            lottoNumberList.add(totalNumberList.get(i));
        }
        Collections.sort(lottoNumberList);

        return lottoNumberList;
    }
}
