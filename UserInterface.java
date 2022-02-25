import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static final String SEPARATOR = ",\\s|,|\\s";

    Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();

    public int inputMoney() {
        String money;
        while (true) {
            InputView.guideInputMoney();
            money = scanner.nextLine();
            if (validation.validateMoney(money)) break;
        }

        return Integer.parseInt(money);
    }

    public int inputCountOfManualLotto(int countOfLotto) {
        String countOfManualLotto;
        while (true) {
            InputView.guideInputCountOfManualLotto();
            countOfManualLotto = scanner.nextLine();
            if (validation.validateCountOfManualLotto(countOfManualLotto, countOfLotto)) break;
        }

        return Integer.parseInt(countOfManualLotto);
    }

    public List<String> inputManualLottoNumber(int countOfManualLotto) {
        List<String> manualLottoNumberList;

        while (true) {
            InputView.guideInputManualLottoNumber();
            manualLottoNumberList = createManualLottoNumberList(countOfManualLotto);

            if (manualLottoNumberList == null) continue;
            break;
        }

        return manualLottoNumberList;
    }

    public List<Integer> inputWinningNumber() {
        String userInput;
        List<Integer> winningNumbers;

        while (true) {
            InputView.guideInputWinningNumber();
            userInput = scanner.nextLine();
            if (validation.validateLottoNumber(userInput)) continue;
            winningNumbers = createLottoNumberList(userInput);
            if (validation.validateRepetition(winningNumbers) == false) break;
        }

        return winningNumbers;
    }

    public int inputBonusNumber() {
        String bonusNumber;
        while (true) {
            InputView.guideInputBonusNumber();
            bonusNumber = scanner.nextLine();
            if (validation.validateBonusNumber(bonusNumber)) break;
        }

        return Integer.parseInt(bonusNumber);
    }

    private List<String> createManualLottoNumberList(int countOfManualLotto) {
        String userInput;
        List<String> manualLottoNumberList = new ArrayList<>();

        int i = 0;
        while (true) {
            userInput = scanner.nextLine();
            if (validation.validateLottoNumber(userInput)) continue;
            if (checkRepetition(userInput)) continue;
            manualLottoNumberList.add(userInput);
            if (++i == countOfManualLotto) break;
        }

        return manualLottoNumberList;
    }

    private boolean checkRepetition(String userInput) {
        return validation.validateRepetition(createLottoNumberList(userInput));
    }

    private List<Integer> createLottoNumberList(String userInput) {
        String[] lottoNumbers = userInput.split(SEPARATOR);
        List<Integer> lottoNumberList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            lottoNumberList.add(Integer.parseInt(lottoNumbers[i]));
        }

        return lottoNumberList;
    }
}
