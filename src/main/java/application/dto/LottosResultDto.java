package application.dto;

import java.util.List;

public class LottosResultDto {
    private List<String> message;
    private double totalRateOfReturn;

    public LottosResultDto(List<String> message, double totalRateOfReturn) {
        this.message = message;
        this.totalRateOfReturn = totalRateOfReturn;
    }
}
