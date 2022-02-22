import domain.User;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        User user = InputView.askHowManyLottos();
        user.buy();
        OutputView.printLottos(user.getLottos());
    }
}
