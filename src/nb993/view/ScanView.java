package nb993.view;

import java.util.Scanner;

public class ScanView {

    private final Scanner sc;

    public ScanView(Scanner sc) {
        this.sc = sc;
    }

    public int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public int[] getWinningNumber() {
        sc.nextLine();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] strNumbers = sc.nextLine().split(",");
        int[] winningNumbers = new int[6];
        for (int i = 0; i < strNumbers.length; i++) {
            winningNumbers[i] = Integer.parseInt(strNumbers[i].trim());
        }
        return winningNumbers;
    }
}
