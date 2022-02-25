package application.controller;

import application.dto.LottoInputDto;
import application.dto.LottoShowDto;
import application.dto.LottosResultDto;
import application.dto.NumberDto;
import application.service.GameService;

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

    public LottoShowDto postBuyLotto(LottoInputDto dto) {
        int money = dto.getInputMoney();
        List<List<Integer>> manualNumbers = dto.getManualNumbers();

        return service.createUser(money, manualNumbers);
    }

    public LottosResultDto postMatchLotto(NumberDto numberDto) {
        int userId = numberDto.getUserId();
        List<Integer> winningNumber = numberDto.getWinningNumber();
        int bonusNumber = numberDto.getBonusNumber();

        return service.createStatistics(userId, winningNumber, bonusNumber);
    }

    public void deleteUserInfo(int userId) {
        service.removeUser(userId);
    }
}
