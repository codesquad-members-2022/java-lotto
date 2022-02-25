package application.routes;

import application.view.InputUtil;
import application.controller.GameController;
import application.dto.LottoInputDto;
import application.dto.LottoShowDto;
import application.dto.LottosResultDto;
import application.dto.NumberDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Collections;
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
            LottoInputDto lottoInputDto = new LottoInputDto(
                    InputUtil.parseNumber(req.queryParams("inputMoney")),
                    InputUtil.parseDoubleListNumber(req.queryParams("manualNumber"))
            );
            LottoShowDto lottoShowDto = controller.postBuyLotto(lottoInputDto, res);

            return render(lottoShowDto.toModel(), "show.html");
        });

        post("/matchLotto", (req, res) -> {
            NumberDto numberDto = new NumberDto(
                    Integer.parseInt(req.cookie("userId")),
                    InputUtil.parseListNumber(req.queryParams("winningNumber")),
                    InputUtil.parseNumber(req.queryParams("bonusNumber"))
            );
            LottosResultDto lottosResultDto = controller.postMatchLotto(numberDto, req);

            return render(lottosResultDto.toModel(), "result.html");
        });

        post("/clearLotto", (req, res) -> {
            controller.deleteUserInfo(req, res);
            return render(Collections.emptyMap(), "index.html");
        });

        exception(IllegalArgumentException.class, (((err, req, res) -> {
            res.status(400);
            res.body(err.getMessage());
        })));

        exception(NoSuchElementException.class, ((err, req, res) -> {
            res.status(404);
            res.body(err.getMessage());
        }));

        exception(RuntimeException.class, (err, req, res) -> {
            err.printStackTrace();
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
