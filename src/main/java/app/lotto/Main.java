package app.lotto;

import app.lotto.domain.*;
import app.lotto.view.InputView;

public class Main {

    public static void main(String[] args) {
        LottoCashier lottoCashier = LottoCashier.receiveOrderAndCreate();
        lottoCashier.showAllLottoTickets();

        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.readWinningNumbersAndCreate();
        System.out.println();

        LottoGameDto result = new LottoGameDto.Builder()
                .addAllLottoTickets(lottoCashier.getAllLottoTickets())
                .setWinningLottoNumbers(winningLottoNumbers)
                .build();

        LottoGame lottoGame = LottoGame.createWithLottoGameDtoAndAmount(result, lottoCashier.getAmount());
        lottoGame.printLottoGameResult();
    }
}
