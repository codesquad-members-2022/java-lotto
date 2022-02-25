package application.routes;

import application.view.InputUtil;
import application.controller.GameController;
import application.dto.LottoInputDto;
import application.dto.LottoShowDto;
import application.dto.LottosResultDto;
import application.dto.NumberDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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

            LottoInputDto lottoInputDto = new LottoInputDto(
                    InputUtil.parseNumber(inputMoney),
                    InputUtil.parseDoubleListNumber(manualNumbers)
            );
            LottoShowDto lottoShowDto = controller.postBuyLotto(lottoInputDto);
            res.cookie("userId", String.valueOf(lottoShowDto.getUserId()));

            return render(lottoShowDto.toModel(), "show.html");
        });

        post("/matchLotto", (req, res) -> {
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");
            int userId = Integer.parseInt(req.cookie("userId"));

            NumberDto numberDto = new NumberDto(
                    userId,
                    InputUtil.parseListNumber(winningNumber),
                    InputUtil.parseNumber(bonusNumber)
            );
            LottosResultDto lottosResultDto = controller.postMatchLotto(numberDto);
            res.cookie("userId", null);

            return render(lottosResultDto.toModel(), "result.html");
        });

        exception(IllegalArgumentException.class, (((err, req, res) -> {
            res.status(400);
            res.body(err.getMessage());
        })));

        exception(NoSuchElementException.class, ((err, req, res) -> {
            res.status(404);
            res.body(err.getMessage());
        }));


    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
