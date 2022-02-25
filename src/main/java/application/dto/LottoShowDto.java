package application.dto;

import application.domain.Lottery;
import application.domain.UserLotteries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoShowDto {

    private final int userId;
    private final int lottosSize;
    private final List<Map<String, List<Integer>>> lottos;

    public LottoShowDto(int userId, UserLotteries userLotteries) {
        List<List<Integer>> numbersList = userLotteries.get().stream()
                .map(Lottery::getNumbers)
                .collect(Collectors.toList());

        this.userId = userId;
        this.lottosSize = numbersList.size();
        this.lottos = numbersList.stream()
                .map(numbers -> new HashMap<String, List<Integer>>() {{
                    put("numbers", numbers);
                }})
                .collect(Collectors.toList());
    }

    public Map<String, Object> toModel() {
        Map<String, Object> model = new HashMap<>();
        model.put("lottosSize", lottosSize);
        model.put("lottos", lottos);

        return model;
    }

    public int getUserId() {
        return userId;
    }
}
