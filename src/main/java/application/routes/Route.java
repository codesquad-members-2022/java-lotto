package application.routes;

import application.view.InputUtil;
import application.controller.GameController;
import application.dto.BundleDto;
import application.dto.LottoShowDto;
import application.dto.LottosResultDto;
import application.dto.NumberDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Route {

    GameController controller = GameController.getInstance();

    public void run() {
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        post("/buyLotto", (req, res) -> {
            String inputMoney = req.queryParams("inputMoney");
            String manualNumbers = req.queryParams("manualNumber");

            BundleDto bundleDto = new BundleDto(
                    InputUtil.parseNumber(inputMoney),
                    InputUtil.parseDoubleListNumber(manualNumbers)
            );
            LottoShowDto lottoShowDto = controller.getUserBundle(bundleDto);

            return render(lottoShowDto.toModel(), "show.html");
        });

        post("/matchLotto", (req, res) -> {
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            NumberDto numberDto = new NumberDto(
                    InputUtil.parseListNumber(winningNumber),
                    InputUtil.parseNumber(bonusNumber)
            );
            LottosResultDto lottosResultDto = controller.getStatistics(numberDto);

            return render(lottosResultDto.toModel(), "result.html");
        });

    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
