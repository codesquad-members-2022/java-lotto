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

	public static int[] getLuckyNumbers() {
		System.out.println(LUCKY_NUMBERS_INFO);
		return trimInputLuckyNumbers();
	}

	private static int[] trimInputLuckyNumbers() {
		String[] split = scanner.nextLine().split(",");
		int[] result = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			result[i] = Integer.parseInt(split[i].trim());
		}

		return result;
	}

}
