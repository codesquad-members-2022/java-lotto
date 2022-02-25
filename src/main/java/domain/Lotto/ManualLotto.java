package domain.Lotto;

import java.util.List;

public class ManualLotto extends Lotto {

    private ManualLotto(List<Integer> lottoNumbers) {
        super(lottoNumbers);
    }

    public static ManualLotto generate(List<Integer> lottoNumbers) {
        return new ManualLotto(lottoNumbers);
    }
}

