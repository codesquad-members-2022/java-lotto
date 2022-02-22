package PACKAGE_NAME.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoStore {
    private static List<Integer> lottoNumbers = new ArrayList<>();


    static{
        init();
    }

    private static void init() {
        IntStream.rangeClosed(1,45)
                .boxed()
                .forEach(number -> lottoNumbers.add(number));
    }




    public LottoStore(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }



}
