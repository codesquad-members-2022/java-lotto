package lotto_game.exception;

import java.util.List;

public class MyException {
    public static int priceException(int price) {
        if (price % 1000 != 0) {
            throw new RuntimeException("잔돈은 필요 없습니다.");
        }
        return price;
    }

    public static int priceMoreThanManual(int inputCountOfManualLotto, int purchaseMoney) {
        if (inputCountOfManualLotto > purchaseMoney / 1000) {
            throw new RuntimeException("낸돈보다 많이 받을 수 없습니다.");
        }
        return inputCountOfManualLotto;
    }

    public static void sixMoreThanManualNumber(String[] manualNumbers) {
        if (manualNumbers.length != 6) {
            throw new RuntimeException("수동 번호의 개수는 6개 입니다.");
        }
    }

    public static int bonusNumberException(int inputBonusNumber) {
        if (inputBonusNumber > 45 || inputBonusNumber < 1) {
            throw new RuntimeException("번호의 범위는 45이하나 1이상이어야 합니다");
        }
        return inputBonusNumber;
    }

    public static boolean numberException(int number) {
        if (number > 45 || number < 1) {
            throw new RuntimeException("번호의 범위는 45이하나 1이상이어야 합니다");
        }
        return true;
    }
}
