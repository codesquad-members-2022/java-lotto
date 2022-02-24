package application.routes;

import application.ParserUtil;
import application.controller.GameController;
import application.dto.BundleDto;
import application.dto.LottoShowDto;
import application.dto.LottosResultDto;
import application.dto.NumberDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import javax.swing.text.html.parser.Parser;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Route {

    GameController controller = new GameController();

    public void run() {
        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        post("/buyLotto", (req, res) -> {
            String inputMoney = req.queryParams("inputMoney");
            String manualNumbers = req.queryParams("manualNumber");

            BundleDto bundleDto = new BundleDto(
                    ParserUtil.parseNumber(inputMoney),
                    ParserUtil.parseDoubleListNumber(manualNumbers)
            );

            LottoShowDto lottoShowDto = controller.getUserBundle(bundleDto);

            Map<String, Object> model = ParserUtil.objectToMap(lottoShowDto);
            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            NumberDto numberDto = new NumberDto(
                    ParserUtil.parseListNumber(winningNumber),
                    ParserUtil.parseNumber(bonusNumber)
            );
            controller.raffle(numberDto);
            LottosResultDto lottosResultDto = controller.calculate();

            Map<String, Object> model = ParserUtil.objectToMap(lottosResultDto);
            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
