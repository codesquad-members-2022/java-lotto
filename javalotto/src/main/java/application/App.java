package application;

import application.domain.Lotto;
import application.view.InputView;
import application.view.OutputView;

public class App {
    public static void main(String[] args) {
        int userPurchaseAmount = InputView.getPurchaseAmount();
        int userPurchaseQuantity = userPurchaseAmount / 1000;
        OutputView.printPurchaseQuantity(userPurchaseQuantity);

        System.out.println(Lotto.createNumbers());
    }
}
