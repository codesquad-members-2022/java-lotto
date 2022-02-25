package model;

import java.util.ArrayList;
import java.util.List;

import utils.InputValidator;
import view.InputView;
import view.OutputView;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;
    private final LottoRepository repository;
    private int price;

    public LottoController() {
        this.repository = new LottoRepository(new ArrayList<>());
    }

    public void buildLotto() {
        //처음 입력 검증단계
        OutputView.requestPrice();
        while (true) {
            price = Integer.parseInt(InputView.requestPrice());
            try {
                InputValidator.validatePriceUnit(price);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printSentence(e.getMessage());
            }
        }

        int count = price / LOTTO_PRICE;

        int manualLottoEach;
        //수동 로또 입력 검증 단계
        OutputView.requestManual();
        while (true) {
            manualLottoEach = Integer.parseInt(InputView.requestManualCount());
            try {
                InputValidator.validateAvailablePurchase(manualLottoEach, count);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printSentence(e.getMessage());
            }
        }

        if (manualLottoEach != 0) {
            LottoMaker manualLottoMaker = LottoMakerFactory.getLottoMaker("manual");
            OutputView.requestManualLottoNumber();
            for (int i = 0; i < manualLottoEach; i++) {
                List<Integer> randomLotto = manualLottoMaker.createLotto();
                checkOverLap(randomLotto);
            }
        }


        while (repository.getLottoList().size() != count) {
            LottoMaker autoLottoMaker = LottoMakerFactory.getLottoMaker("auto");
            List<Integer> autoLotto = autoLottoMaker.createLotto();
            checkOverLap(autoLotto);
        }

        OutputView.printPurchaseCount(count, manualLottoEach, repository.getLottoList());
    }

    private void checkOverLap(List<Integer> lists) {
        repository.checkOverLap(lists);
    }

    public void checkWinNumber() {
        OutputView.requestWinNumber();
        String winNumber;
        while (true) {
            winNumber = InputView.requestWinNumber();
            try {
                InputValidator.validateNumberOfLotto(winNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printSentence(e.getMessage());
            }
        }
        String[] winNumbers = winNumber.split(", ");

        String bonusNumber;
        OutputView.requestBonusNumber();
        while (true) {
            bonusNumber = InputView.requestBonusNumber();
            try {
                InputValidator.validateRangeAboutSingleNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printSentence(e.getMessage());
            }
        }

        repository.checkWinNumber(winNumbers, bonusNumber, price);
        InputView.scannerClose();
    }

}
