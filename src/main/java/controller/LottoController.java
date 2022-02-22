package controller;

import domain.Money;
import domain.lotto.LottoTickets;
import view.input.InputView;
import view.output.OutputView;

public class LottoController {

    private LottoController() {
    }

    public void run() {
        Money money = InputView.inputMoney();
        LottoTickets lottoTickets = LottoTickets.createRandomTickets(money);
        OutputView.printLottoTickets(lottoTickets);

        //TODO : 당첨번호 입력 받기
        //TODO : 당첨번호매칭 -> 결과 받아오기
        //TODO : 결과를 OutputView에게 넘겨서 출력하기

        InputView.close();
    }

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
