package app.lotto;

import app.lotto.domain.*;
import app.lotto.view.InputView;

public class Main {

    public static void main(String[] args) {
        LottoCashier lottoCashier = LottoCashier.receiveOrderAndCreate();
        lottoCashier.showAllLottoTickets();

        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.readWinningNumbersAndCreate();
        System.out.println();

        LottoGameDto lottoGameDto = new LottoGameDto(lottoCashier.getAllLottoTickets(), winningLottoNumbers);

        LottoGame lottoGame = LottoGame.createWithLottoGameDtoAndAmount(lottoGameDto, lottoCashier.getAmount());
        lottoGame.printLottoGameResult();
    }
}
