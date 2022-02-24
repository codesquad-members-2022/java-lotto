import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static final String SEPARATOR = ",\\s|,|\\s";

    Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();

    public int inputMoney() {
        int money;
        while (true) {
            InputView.guideInputMoney();
            money = validation.validateMoney(scanner.nextLine());
            if (money > -1) break;
        }

        return money;
    }

    public int inputCountOfManualLotto(int countOfLotto) {
        int countOfManualLotto;
        while (true) {
            InputView.guideInputCountOfManualLotto();
            countOfManualLotto = validation.validateCountOfManualLotto(scanner.nextLine(), countOfLotto);
            if (countOfManualLotto > -1 ? true : false) break;
        }

        return countOfManualLotto;
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
            userInput = validation.validateLottoNumber(scanner.nextLine());
            if (userInput == null) continue;
            winningNumbers = createLottoNumberList(userInput);
            if (validation.validateRepetition(winningNumbers) == false) break;
        }

        return winningNumbers;
    }

    public int inputBonusNumber() {
        int bonusNumber;
        while (true) {
            InputView.guideInputBonusNumber();
            bonusNumber = validation.validateBonusNumber(scanner.nextLine());
            if (bonusNumber > -1 ? true : false) break;
        }

        return bonusNumber;
    }

    private List<String> createManualLottoNumberList(int countOfManualLotto) {
        String userInput;
        List<String> manualLottoNumberList = new ArrayList<>();

        for (int i = 0; i < countOfManualLotto; i++) {
            userInput = validation.validateLottoNumber(scanner.nextLine());
            if (userInput == null || checkRepetition(userInput)) return null;
            manualLottoNumberList.add(userInput);
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
