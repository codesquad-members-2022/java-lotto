package application.dto;

import java.util.List;

public class BundleDto {

    private int inputMoney;
    private List<List<Integer>> manualNumbers;

    public BundleDto(int inputMoney, List<List<Integer>> manualNumbers) {
        this.inputMoney = inputMoney;
        this.manualNumbers = manualNumbers;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public List<List<Integer>> getManualNumbers() {
        return manualNumbers;
    }
}
