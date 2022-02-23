package nb993.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import nb993.util.LottoUtil;

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

    public int getManualPurchaseCount(int purchaseLimit) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            int manualPurchaseCount = sc.nextInt();
            sc.nextLine();
            LottoUtil.validatePurchaseLimit(purchaseLimit, manualPurchaseCount);
            return manualPurchaseCount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualPurchaseCount(purchaseLimit);
        }
    }

    public List<Integer> getNumbers() {
        String[] strNumbers = sc.nextLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < strNumbers.length; i++) {
            numbers.add(Integer.parseInt(strNumbers[i].trim()));
        }

        return numbers;
    }

    public List<List<Integer>> getManualNumber(int count) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        List<List<Integer>> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTicketList.add(getNumbers());
        }

        return lottoTicketList;
    }
}
