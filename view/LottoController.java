package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.LottoGame;
import PACKAGE_NAME.domain.LottoTickets;

public class LottoController {

    private LottoGame lottoGame = new LottoGame();

    public LottoTickets getLottoTickets(int money) {
        return new LottoTickets(lottoGame.getLottoTickets(money));
    }

    public GameResult getLottoGameResult(InputElements elements) {
        return lottoGame.getResult(elements);
    }
}
