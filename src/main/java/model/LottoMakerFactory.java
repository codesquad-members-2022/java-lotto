package model;

import java.util.HashMap;
import java.util.Map;

public class LottoMakerFactory {
    private static Map<String, LottoMaker> makerStorage;

    static {
        makerStorage = new HashMap<>();
        makerStorage.put("auto", new AutoLottoMaker());
        makerStorage.put("manual", new ManualLottoMaker());
    }

    public static LottoMaker getLottoMaker(String lottoMakerTypes) {
        return makerStorage.get(lottoMakerTypes);
    }
}
