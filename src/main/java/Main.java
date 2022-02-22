import model.LottoController;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.buildLotto();
        controller.checkWinNumber();
      }
}
