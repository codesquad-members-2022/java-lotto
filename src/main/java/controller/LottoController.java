package controller;

import domain.Money;
import view.input.InputView;

public class LottoController {

    private LottoController() {
    }

    public void run() {
        Money money = InputView.inputMoney();
        //TODO : 컨트롤러에서, ~에게 요청해서 로또 번호 리스트를 가져오기
        //TODO : OutputView는 구매한 티켓들을 출력
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
