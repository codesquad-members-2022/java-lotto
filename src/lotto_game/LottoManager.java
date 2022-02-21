package lotto_game;

import lotto_game.domain.LottoGames;
import lotto_game.view.InputView;
import lotto_game.view.OutputView;

public class LottoManager {
    public static final int EACH_LOTTO_PRICE = 1000;

    public void startLottoGames() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int purchaseMoney = inputView.inputPrice();
        int numberOfLottoGames = purchaseMoney / EACH_LOTTO_PRICE;

        // 로또 게임 생성
        LottoGames lottoGames = new LottoGames();
        lottoGames.initLottoGames(numberOfLottoGames);

        // 로또 게임 정보 출력
        outputView.printLottoGamesSize(lottoGames);
        outputView.printLottoGames(lottoGames);

        // 통계 처리
        LottoStatistics lottoStatistics = new LottoStatistics();
        inputView.removeBlank();
        String winsNumbers = inputView.inputWinNumbers();
        int rate = lottoStatistics.calculateProfitRate(winsNumbers, lottoGames, purchaseMoney);

        // 통계 출력
        outputView.printProfitRate(rate, lottoStatistics.getLottoResult().getResultMap());
    }
}
