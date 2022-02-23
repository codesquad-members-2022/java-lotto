package model;

import java.util.Collections;
import java.util.List;

public class LottoRepository {

    private final List<Lotto> lottoList;

    public LottoRepository(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void checkOverLap(List<Integer> lists) {
        int size = (int)lottoList.stream()
            .filter(l -> l.sameList(lists)).count();
        sortingNumber(lists, size);
    }

    private void sortingNumber(List<Integer> lists, int size) {
        if (size == 0) {
            Collections.sort(lists);
            lottoList.add(new Lotto(lists));
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
