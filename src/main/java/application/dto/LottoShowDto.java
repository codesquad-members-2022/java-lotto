package application.dto;

import java.util.List;

public class LottoShowDto {

    private int lottoSize;
    private List<List<Integer>> lottos;

    public LottoShowDto(int lottoSize, List<List<Integer>> lottos) {
        this.lottoSize = lottoSize;
        this.lottos = lottos;
    }

    public int getLottoSize() {
        return lottoSize;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
