package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.LottoGame;
import PACKAGE_NAME.domain.LottoTickets;
import PACKAGE_NAME.domain.Money;

public class LottoController {

    private LottoGame lottoGame = new LottoGame();

    public LottoTickets getLottoTickets(Money money) {
        return new LottoTickets(lottoGame.getLottoTickets(money));
    }

    public GameResult getLottoGameResult(LottoGameElements elements) {
        return lottoGame.getResult(elements);
    }
}
