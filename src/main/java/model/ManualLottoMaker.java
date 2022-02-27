package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utils.InputValidator;
import view.InputView;
import view.OutputView;

public class ManualLottoMaker implements LottoMaker {
    @Override
    public List<Integer> createLotto() {
        String manualLottoNumber;
        while (true) {
            manualLottoNumber = InputView.requestManualLottoNumber();
            try {
                InputValidator.validateNumberOfLotto(manualLottoNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printSentence(e.getMessage());
            }
        }
        return makeManualLotto(manualLottoNumber);
    }

    private List<Integer> makeManualLotto(String manualLottoNumber) {
        String[] split = manualLottoNumber.split(", ");
        return Arrays.stream(split)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

}
