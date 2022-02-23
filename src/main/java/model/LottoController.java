package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        price = Integer.parseInt(InputView.requestPrice());
        int count = price / LOTTO_PRICE;
        int manualLottoEach = Integer.parseInt(InputView.requestManual());

        if (manualLottoEach != 0) {
            makeManualLottoPerCount(manualLottoEach);
        }

        // TODO!!
        while (repository.getLottoList().size() != (count - manualLottoEach)) {
            Set<Integer> numbers = makeRandomNumberSet();
            checkOverLap(new ArrayList<>(numbers));
        }
        OutputView.printPurchaseCount(count - manualLottoEach, repository.getLottoList());
    }

    private void makeManualLottoPerCount(int manualLottoEach) {
        String manualLottoNumber;
        OutputView.requestManualLottoNumber();
        while (manualLottoEach-- > 0) {
            manualLottoNumber = InputView.requestManualLottoNumber(manualLottoEach);
            makeManualLotto(manualLottoNumber);
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
        String winNumber = InputView.requestWinNumber();
        String[] winNumbers = winNumber.split(", ");
        String bonusNumber = InputView.requestBonusNumber();
        repository.checkWinNumber(winNumbers, bonusNumber, price);
    }

}
