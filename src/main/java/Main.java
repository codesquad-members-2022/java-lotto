import controller.LottoController;
import view.InputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoController lottoController = new LottoController(inputView);
    }
}
