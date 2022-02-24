package PACKAGE_NAME.domain;

public class RateOfReturnCalculator {
    public double calculateRateOfReturn(int sum, int inputMoney) {
        double rateOfReturn = (sum - inputMoney) * 100 / inputMoney;
        return Math.round(rateOfReturn * 100) / 100;
    }
}
