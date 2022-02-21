package application;

import java.util.List;

import application.domain.Lotto;
import application.view.InputView;
import application.view.OutputView;

public class App {
    public static void main(String[] args) {
        int userPurchaseAmount = InputView.getPurchaseAmount();
        int userPurchaseQuantity = userPurchaseAmount / 1000;
        OutputView.printPurchaseQuantity(userPurchaseQuantity);
        for (int i = 0; i < userPurchaseQuantity; i++) {
            OutputView.printLottoNumbers(Lotto.createNumbers());
        }
        List<Integer> userWinningNumber = InputView.getWinningNumber();
    }
}
