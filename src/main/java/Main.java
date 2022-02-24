import domain.LottoGame;
import view.InputView;

public class Main {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.purchaseAmount());
        lottoGame.start();
    }

}
