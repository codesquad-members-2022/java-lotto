package application.dto;

import application.domain.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottosResultDto {
    private final List<String> message;
    private final double totalRateOfReturn;

    public LottosResultDto(Map<Prize, Integer> prizes, double totalRateOfReturn) {
        this.message = getMessage(prizes);
        this.totalRateOfReturn = totalRateOfReturn;
    }

    public Map<String, Object> toModel() {
        Map<String, Object> model = new HashMap<>();
        model.put("lottosResult", new HashMap<String, Object>() {{
            put("message", message);
            put("totalRateOfReturn", String.format("%.2f", totalRateOfReturn));
        }});

        return model;
    }

    private List<String> getMessage(Map<Prize, Integer> prizes) {
        return prizes.keySet().stream().map(key ->
                String.format("%d개 일치%s%d원) - %d개%s",
                        key.getResult().getMatchCount(),
                        key.getResult().getBonus() != null && key.getResult().getBonus() ? ", 보너스 볼 일치(" : " (",
                        key.getReward(), prizes.get(key),
                        System.lineSeparator())).collect(Collectors.toList());
    }
}
