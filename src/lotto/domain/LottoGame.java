package lotto.domain;

import lotto.view.View;
import spark.Request;

import java.util.List;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class LottoGame {
    private final View view = new View();
    private LottoBundle lottoBundle;

    public void run() {
        port(8080);

        get("/", (req, res) -> view.getPayment());

        post("/buyLotto", (req, res) -> {
            try {
                lottoBundle = LottoBundle.createByCashValue(InputParser.parseInt(req.queryParams("inputMoney")));
                return view.getManualNumbers(lottoBundle);
            } catch (Exception e) {
                return view.getPayment(e.getMessage());
            }
        });

        post("/finalizeLotto", (req, res) -> {
            try {
                lottoBundle.addManualLottoTickets(getLottoTicketsFromQuery(req));
                lottoBundle.fillWithRandomLottoTickets();
                return view.getWinningNumber(lottoBundle);
            } catch (InvalidLottoNumberException | NumberFormatException e) {
                return view.getManualNumbers(lottoBundle, e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                return view.getWinningNumber(lottoBundle, e.getMessage());
            }
        });

        post("/matchLotto", (req, res) -> {
            try {
                LottoResult lottoResult = LottoResult.of(lottoBundle, getWinningNumberFromQuery(req));
                return view.showResult(lottoResult);
            } catch (InvalidLottoNumberException | NumberFormatException e) {
                return view.getWinningNumber(lottoBundle, e.getMessage());
            }
        });
    }

    private WinningNumber getWinningNumberFromQuery(Request req) {
        return WinningNumber.withManualNumbers(
                InputParser.parseIntArray(req.queryParamsValues(WinningNumber.INPUT_FIELD_NAME)),
                InputParser.parseInt(req.queryParams(WinningNumber.BONUS_INPUT_FIELD_NAME)));
    }

    private List<LottoTicket> getLottoTicketsFromQuery(Request req) {
        return req.queryParams().stream()
                .filter(s -> s.startsWith(LottoNumbers.INPUT_FIELD_NAME))
                .sorted()
                .map(req::queryParamsValues)
                .map(InputParser::parseIntArray)
                .map(LottoTicket::withManualNumbers)
                .collect(Collectors.toList());
    }
}
