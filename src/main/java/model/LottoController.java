package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import utils.InputValidator;
import view.InputView;
import view.OutputView;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> range = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
        .boxed()
        .collect(Collectors.toList());

    private final LottoRepository repository;
    private int price;

    public LottoController() {
        this.repository = new LottoRepository(new ArrayList<>());
    }

    public void buildLotto() {
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
            makeManualLottoPerCount(manualLottoEach);
        }

        while (repository.getLottoList().size() != count) {
            Set<Integer> numbers = makeRandomNumberSet();
            checkOverLap(new ArrayList<>(numbers));
        }
        OutputView.printPurchaseCount(count, manualLottoEach, repository.getLottoList());
    }

    private void makeManualLottoPerCount(int manualLottoEach) {
        String manualLottoNumber;
        OutputView.requestManualLottoNumber();

        while (manualLottoEach > 0) {
            while (true) {
                manualLottoNumber = InputView.requestManualLottoNumber();
                try {
                    InputValidator.validateNumberOfLotto(manualLottoNumber);
                    break;
                } catch (IllegalArgumentException e) {
                    OutputView.printSentence(e.getMessage());
                }
            }
            makeManualLotto(manualLottoNumber);
            manualLottoEach--;
        }
    }

    private void makeManualLotto(String manualLottoNumber) {
        String[] split = manualLottoNumber.split(", ");
        List<Integer> collect = Arrays.stream(split)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
        checkOverLap(collect);
    }

    private Set<Integer> makeRandomNumberSet() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != MAX_NUMBER_COUNT) {
            Collections.shuffle(range);
            numbers.add(range.get(0));
        }
        return numbers;
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
