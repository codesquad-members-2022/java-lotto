package application.controller;

import application.dto.LottoInputDto;
import application.dto.LottoShowDto;
import application.dto.LottosResultDto;
import application.dto.NumberDto;
import application.service.GameService;
import spark.Request;
import spark.Response;

import java.util.List;

public class GameController {

    private static GameController controller;
    private static GameService service = GameService.getInstance();

    private GameController() {}

    public static GameController getInstance() {
        if (controller == null) {
            controller = new GameController();
        }
        return controller;
    }

    public LottoShowDto postBuyLotto(LottoInputDto dto, Response response) {
        int money = dto.getInputMoney();
        List<List<Integer>> manualNumbers = dto.getManualNumbers();

        LottoShowDto lottoShowDto = service.createUser(money, manualNumbers);
        response.cookie("userId", String.valueOf(lottoShowDto.getUserId()));

        return lottoShowDto;
    }

    public LottosResultDto postMatchLotto(NumberDto numberDto, Request request) {
        List<Integer> winningNumber = numberDto.getWinningNumber();
        int bonusNumber = numberDto.getBonusNumber();

        return service.createStatistics(Integer.parseInt(request.cookie("userId")), winningNumber, bonusNumber);
    }

    public void deleteUserInfo(Request request, Response response) {
        int userId = Integer.parseInt(request.cookie("userId"));
        response.removeCookie("userId");

        service.removeUser(userId);
    }
}
