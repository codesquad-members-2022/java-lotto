import java.util.Arrays;
import java.util.Scanner;

public class Input {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String LUCKY_NUMBERS_INFO = "당첨 번호를 입력해 주세요.";

	private Input() {
	}

	public static int getInputMoney(String message) {
		System.out.println(message);
		int money = scanner.nextInt();
		scanner.nextLine();
		return money;
	}

	public static String[] getLuckyNumbers() {
		System.out.println(LUCKY_NUMBERS_INFO);
		return trimInputLuckyNumbers();
	}

	private static String[] trimInputLuckyNumbers() {
		String[] split = scanner.nextLine().split(",");
		for (int i = 0; i < split.length; i++) {
			split[i] = split[i].trim();
			System.out.println(split[i]);
		}
		return split;
	}

}
