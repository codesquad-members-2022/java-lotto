import java.util.Scanner;

public class Input {

	private static Scanner scanner = new Scanner(System.in);

	private Input() {
	}

	public static int getInputMoney(String message) {
		System.out.println(message);
		int money = scanner.nextInt();
		// TODO 나중에 없애기
		scanner.nextLine();

		return money;
	}
}
