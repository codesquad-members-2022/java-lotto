package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        // 구입 금액을 입력받아 로또복권 뭉치를 생성한다. 유효한 구입 금액이 입력될 때까지 반복한다.
        LottoBundle lottoBundle = createLottoBundle();

        // 수동 복권 장수를 입력받고, 1장 이상이라면 수동 복권을 생성하여 로또 뭉치에 더한다.
        addManualLottoTicketsIfAny(lottoBundle, getManualTicketCount(lottoBundle));

        // 복권 뭉치의 남은 복권 수를 자동 복권으로 채운다.
        lottoBundle.fillWithRandomLottoTickets();

        // 구매 결과를 출력한다.
        outputView.printPurchaseResult(lottoBundle);

        // 당첨 번호를 입력받아 로또 결과를 판독한다. 유효한 당첨번호가 입력될 때까지 반복한다.
        LottoResult lottoResult = LottoResult.of(lottoBundle, getWinningNumber());

        // 로또 결과를 출력한다.
        outputView.printLottoResult(lottoResult);

        // InputView 객체가 점유하고 있는 입력 자원을 반납한다.
        inputView.close();
    }

    private LottoBundle createLottoBundle() {
        return repeatSupplierUntilSuccessful(
                () -> LottoBundle.createByCashValue(inputView.getPaidAmount()));
    }

    private void addManualLottoTicketsIfAny(LottoBundle lottoBundle, int manualTicketCount) {
        if (manualTicketCount < 1) {
            return;
        }

        // 수동 번호를 입력받아 복권을 생성한다. 유효한 번호들만 입력될 때까지 반복한다.
        List<LottoTicket> lottoTicketList = repeatSupplierUntilSuccessful(() ->
                getManualLottoTickets(manualTicketCount));

        // 수동 복권 수가 복권 뭉치의 한도를 넘으려고 하면 중단하고 다음으로 넘어간다.
        // 수동으로 입력할 복권 장수를 입력받을 때 입력값이 복권 뭉치 크기보다 작게 제한하기 때문에 실제로 중단이 일어나는 경우는 없다.
        tryConsumer(lottoBundle::addManualLottoTickets, lottoTicketList);
    }

    private List<LottoTicket> getManualLottoTickets(int manualTicketCount) {
        int[][] numbers = inputView.getManualLottoNumbers(manualTicketCount);
        return Stream.of(numbers)
                .map(LottoTicket::withManualNumbers)
                .collect(Collectors.toList());
    }

    private int getManualTicketCount(LottoBundle lottoBundle) {
        return repeatSupplierUntilSuccessful(
                () -> inputView.getManualTicketCount(lottoBundle.count()));
    }

    private WinningNumber getWinningNumber() {
        return repeatSupplierUntilSuccessful(
                () -> WinningNumber.withManualNumbers(inputView.getWinningNumber(), inputView.getBonusNumber()));
    }

    private <T> T repeatSupplierUntilSuccessful(Supplier<T> supplier) {
        T result = null;

        while (result == null) {
            result = trySupplier(supplier);
        }

        return result;
    }

    private <T> T trySupplier(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (InvalidLottoNumberException e) {
            outputView.printMessage(e.getMessage());
        }

        return null;
    }

    private <T> void tryConsumer(Consumer<T> consumer, T t) {
        try {
            consumer.accept(t);
        } catch (Exception e) {
            outputView.printMessage(e.getMessage());
        }
    }
}
