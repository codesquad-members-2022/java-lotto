package nb993.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanView {

    private final Scanner sc;

    public ScanView(Scanner sc) {
        this.sc = sc;
    }

    public int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        int purchaseAmount = sc.nextInt();
        sc.nextLine();
        return purchaseAmount;
    }

    public List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return getNumbers();
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = sc.nextInt();
        sc.nextLine();
        return bonusNumber;
    }

    public int getManualPurchaseCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualPurchaseCount = sc.nextInt();
        sc.nextLine();
        return manualPurchaseCount;
    }

    public List<Integer> getNumbers() {
        String[] strNumbers = sc.nextLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < strNumbers.length; i++) {
            numbers.add(Integer.parseInt(strNumbers[i].trim()));
        }

        return numbers;
    }

    public List<Integer> getManualNumber() {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        return getNumbers();
    }
}
