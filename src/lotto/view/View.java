package lotto.view;

import lotto.domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class View {
    public String getPayment() {
        return getPayment("");
    }

    public String getPayment(String errorMessage) {
        Map<String, Object> model = new HashMap<>();
        model.put("price", LottoTicket.PRICE);
        model.put("errorMessage", errorMessage);
        return render(model, "index.html");
    }

    public String getManualNumbers(LottoBundle lottoBundle) {
        return getManualNumbers(lottoBundle, "");
    }

    public String getManualNumbers(LottoBundle lottoBundle, String errorMessage) {
        Map<String, Object> model = new HashMap<>();
        model.put("moneyValue", lottoBundle.getCashValue());
        model.put("maxCount", lottoBundle.count());
        model.put("lottoMin", LottoNumber.MINIMUM_NUMBER);
        model.put("lottoMax", LottoNumber.MAXIMUM_NUMBER);
        model.put("lottoLength", LottoNumbers.LOTTO_NUMBER_COUNT);
        model.put("lottoNumbersFieldName", LottoNumbers.INPUT_FIELD_NAME);
        model.put("errorMessage", errorMessage);
        return render(model, "select.html");
    }

    public String getWinningNumber(LottoBundle lottoBundle) {
        return getWinningNumber(lottoBundle, "");
    }

    public String getWinningNumber(LottoBundle lottoBundle, String errorMessage) {
        Map<String, Object> model = new HashMap<>();
        model.put("lottosSize", lottoBundle.count());
        model.put("lottos", lottoBundle.getLottoTickets());
        model.put("lottoMin", LottoNumber.MINIMUM_NUMBER);
        model.put("lottoMax", LottoNumber.MAXIMUM_NUMBER);
        model.put("lottoLength", LottoNumbers.LOTTO_NUMBER_COUNT);
        model.put("winningNumbersFieldName", WinningNumber.INPUT_FIELD_NAME);
        model.put("errorMessage", errorMessage);
        return render(model, "show.html");
    }

    private String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(
                new ModelAndView(model, templatePath));
    }

    public String showResult(LottoResult lottoResult) {
        Map<String, Object> model = new HashMap<>();
        model.put("lottosResult", lottoResult);
        return render(model, "result.html");
    }
}
