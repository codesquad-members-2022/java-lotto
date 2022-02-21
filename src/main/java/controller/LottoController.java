package controller;

import domain.Lotto;
import domain.LottoMaker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import view.InputView;

public class LottoController {

    private InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void runLotto() {
        try {
            int balance = inputView.getInput();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<Lotto> order(int balance) {
        List<Lotto> lotteries = new ArrayList<>();
        int lottoCount = balance / Lotto.PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lotteries.add(LottoMaker.make());
        }
        return lotteries;
    }

}
