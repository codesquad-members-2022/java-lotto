import static views.Input.*;
import static views.Output.*;


public class Main {
	public static void main(String[] args) {
		println.accept("구입금액을 입력해 주세요.");
		int purchaseAmount = nextInt();

		int ticketAccount = purchaseAmount / 1000;
		println.accept(ticketAccount+"개를 구매했습니다.");

		scanClose();
	}

}
