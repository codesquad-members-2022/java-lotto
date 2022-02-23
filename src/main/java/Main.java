import model.LottoController;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.buildLotto();
        controller.checkWinNumber();
      }
}
