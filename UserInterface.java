import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static final String SEPARATOR = ",\\s|,|\\s";
    Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        InputView.guideInputMoney();
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputCountOfManualLotto(){
        InputView.guideInputCountOfManualLotto();
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> inputManualLottoNumber(int countOfManualLotto){
        InputView.guideInputManualLottoNumber();
        List<String> manualLottoNumberList = new ArrayList<>();
        for (int i = 0; i < countOfManualLotto; i++) {
            manualLottoNumberList.add(scanner.nextLine());
        }
        return manualLottoNumberList;
    }

    public List<Integer> inputWinningNumber() {
        InputView.guideInputWinningNumber();
        String[] str = scanner.nextLine().split(SEPARATOR);
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(str[i]));
        }
        return winningNumbers;
    }

    public int inputBonusBall() {
        InputView.guideInputBonusBall();
        return Integer.parseInt(scanner.nextLine());
    }

}
