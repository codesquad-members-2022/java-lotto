package application;

import view.InputView;
import view.OutputView;

public class App {
    public static void main(String[] args) {
        int userPurchaseAmount = InputView.getPurchaseAmount();
        int userPurchaseQuantity = userPurchaseAmount / 1000;
        OutputView.printPurchaseQuantity(userPurchaseQuantity);
    }
}
