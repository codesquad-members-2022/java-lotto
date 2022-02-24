import java.util.Scanner;

import controller.LottoController;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputView inputView = new InputView(sc);
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(inputView, outputView);
        lottoController.runLotto();
        sc.close();
    }
}
