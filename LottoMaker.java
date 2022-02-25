import java.util.List;

public abstract class LottoMaker {

    public abstract List<Lotto> getLottoList(int countOfLotto);

    protected abstract List<Integer> makeLottoNumber();
}
