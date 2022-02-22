import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        InputView.guideInputMoney();
        return Integer.parseInt(scanner.nextLine());
    }
}
