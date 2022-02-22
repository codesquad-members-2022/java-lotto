public class LottoGame {

    public void run() {
        UserInterface ui = new UserInterface();
        int purchaseMoney = ui.inputMoney();
        int lottoCount = purchaseMoney / 1000;
        OutputView.showLottoCount(lottoCount);
    }
}
