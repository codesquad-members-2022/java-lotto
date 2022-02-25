import model.LottoController;

public class Guest {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.buildLotto();
        controller.checkWinNumber();
      }
}
