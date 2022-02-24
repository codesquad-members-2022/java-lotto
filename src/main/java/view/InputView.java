package view;

import domain.LottoCashier;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String ASK_PURCHASING_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int getPurchasingAmount() {
        System.out.println(ASK_PURCHASING_AMOUNT);
        int purchasingAmount =  Integer.parseInt(scanner.nextLine());
        validatePurchasingAmount(purchasingAmount);
        return purchasingAmount;
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
        String winningValue = scanner.nextLine();
        return Arrays.stream(winningValue.split(","))
                     .map(String::trim)
                     .mapToInt(Integer::parseInt)
                     .boxed()
                     .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void validatePurchasingAmount(int purchasingAmount) {
        if (purchasingAmount < LottoCashier.LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구매할 돈이 부족합니다!!");
        }
    }
}
