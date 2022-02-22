package nb993.view;

import java.sql.Array;
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
        return sc.nextInt();
    }

    public List<Integer> getWinningNumber() {
        sc.nextLine();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] strNumbers = sc.nextLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < strNumbers.length; i++) {
            winningNumbers.add(Integer.parseInt(strNumbers[i].trim()));
        }
        return winningNumbers;
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
