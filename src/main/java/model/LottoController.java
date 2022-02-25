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
        OutputView.requestPrice();
        requestTotalAmount();
        int count = price / LOTTO_PRICE;
        int manualLottoEach = numberOfTheLottoByManual(count);
        makeManualLotto(manualLottoEach);
        makeRandomLotto(count);
        OutputView.printPurchaseCount(count, manualLottoEach, repository.getLottoList());
    }

    /**
     * 전체 요금 입력
     */
    private void requestTotalAmount() {
        while (true) {
            price = Integer.parseInt(InputView.requestPrice());
            try {
                InputValidator.validatePriceUnit(price);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printSentence(e.getMessage());
            }
        }
    }

    /**
     * 수동으로 만들 로또 수를 입력받아, 구매 가능한 수인지 검증
     * @param count
     * @return
     */
    private int numberOfTheLottoByManual(int count) {
        int manualLottoEach;
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
        return manualLottoEach;
    }

    /**
     * manualLottoEach만큼 수동 로또를 만들기
     * @param count
     */
    private void makeManualLotto(int count) {
        if (count != 0) {
            LottoMaker manualLottoMaker = LottoMakerFactory.getLottoMaker("manual");
            OutputView.requestManualLottoNumber();
            createManualLottoByNumber(count, manualLottoMaker);
        }
    }

    /**
     * count만큼 자동 로또 만들기
     * @param count
     */
    private void makeRandomLotto(int count) {
        while (repository.getLottoList().size() != count) {
            LottoMaker autoLottoMaker = LottoMakerFactory.getLottoMaker("auto");
            List<Integer> autoLotto = autoLottoMaker.createLotto();
            checkOverLap(autoLotto);
        }
    }

    /**
     * count만큼 반복하며 랜덤 로또 리스트를 만들고, overlap 체크를 요청
     * @param count
     * @param manualLottoMaker
     */
    private void createManualLottoByNumber(int count, LottoMaker manualLottoMaker) {
        for (int i = 0; i < count; i++) {
            List<Integer> randomLotto = manualLottoMaker.createLotto();
            checkOverLap(randomLotto);
        }
    }

    /**
     * repository에 list(로또 번호)가 오버랩되는지 확인 요청
     * @param lists
     */
    private void checkOverLap(List<Integer> lists) {
        repository.checkOverLap(lists);
    }

    /**
     * 사용자로부터 당첨번호와 보너스 번호를 받아 당첨자 체크 수행
     */
    public void checkWinNumber() {
        OutputView.requestWinNumber();
        String[] winNumbers = requestWinNumber();
        String bonusNumber = requestBonusNumber();
        repository.checkWinNumber(winNumbers, bonusNumber, price);
        InputView.scannerClose();
    }

    private String[] requestWinNumber() {
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
        return winNumber.split(", ");
    }

    private String requestBonusNumber() {
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
        return bonusNumber;
    }
}
