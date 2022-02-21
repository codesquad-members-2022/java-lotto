package model;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private int price;
    private static final int LOTTO_PRICE = 1000;
    private int count;
    private List<Lotto> list = new ArrayList<>();


    public void buildLotto() {
        price = Integer.parseInt(InputView.requestPrice());
        count = price / LOTTO_PRICE;

        for (int i = 0; i < count; i++) {
            list.add(new Lotto());
        }
    }
}
