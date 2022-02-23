package com.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String REQUEST_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
	private static final String REQUEST_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

	private static final Scanner scanner = new Scanner(System.in);

	public int getPurchaseAmount() {
		System.out.println(REQUEST_AMOUNT_MESSAGE);
		return Integer.parseInt(scanner.nextLine());
	}

	public List<Integer> getWinningNumbers() {
		System.out.println(REQUEST_WINNING_NUMBERS_MESSAGE);
		String[] winningNumbers = scanner.nextLine().replaceAll(" ", "").split(",");
		return Arrays.stream(winningNumbers).map(Integer::parseInt).collect(Collectors.toList());
	}

	public int inputBonusNumber() {
		System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
		return scanner.nextInt();
	}
}
