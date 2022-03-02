package app.lotto;

import app.lotto.domain.*;

public class Main {

    public static void main(String[] args) {
        LottoCashier lottoCashier = LottoCashier.createWithReceiveOrder();
        lottoCashier.showAllLottoTickets();

        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.readWinningNumbersAndCreate();
        System.out.println();

        LottoGameDto lottoGameDto = new LottoGameDto(lottoCashier.getAllLottoTickets(), winningLottoNumbers);

        LottoGame lottoGame = LottoGame.createWithLottoGameDtoAndAmount(lottoGameDto, lottoCashier.getAmount());
        lottoGame.printLottoGameResult();
    }
}
