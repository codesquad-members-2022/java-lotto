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
}
