package view;

import controller.LottoGame;

import domain.LottoSheet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String ASK_PURCHASING_MONEY = "구입금액을 입력해 주세요.";
    private static final String ASK_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ASK_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int getPurchasingMoney() {
        System.out.println(ASK_PURCHASING_MONEY);
        int purchasingAmount = Integer.parseInt(scanner.nextLine());
        validatePurchasingMoney(purchasingAmount);
        return purchasingAmount;
    }

    public static int getManualLottoQuantity(int purchaseQuantity) {
        System.out.println(ASK_MANUAL_LOTTO_COUNT);
        int manualLottoQuantity = Integer.parseInt(scanner.nextLine());
        validateManualLottoQuantity(manualLottoQuantity, purchaseQuantity);
        return manualLottoQuantity;
    }

    public static List<LottoSheet> getManualLottoNumbers(int manualLottoCount) {
        System.out.println(ASK_MANUAL_LOTTO_NUMBERS);
        List<LottoSheet> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String lottoNumbers = scanner.nextLine();
            LottoSheet lottoSheet = new LottoSheet(getNumbers(lottoNumbers));
            manualLottoNumbers.add(lottoSheet);
        }
        return manualLottoNumbers;
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
        String winningValue = scanner.nextLine();
        return getNumbers(winningValue);
    }

    private static List<Integer> getNumbers(String values) {
        return Arrays.stream(values.split(","))
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void validatePurchasingMoney(int purchasingMoney) {
        if (purchasingMoney < LottoGame.LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구매할 돈이 부족합니다!!");
        }
    }

private static void validateManualLottoQuantity(int manualLottoQuantity, int purchaseQuantity) {
        if(manualLottoQuantity < 0 || manualLottoQuantity > purchaseQuantity) {
            throw new IllegalArgumentException("로또 수동 구매가 불가능합니다!!");
        }
}
}
