package com.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.lotto.util.ValidationUtil;

public class InputView {
	private static final String REQUEST_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
	private static final String REQUEST_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
	private static final String REQUEST_MANUAL_NUMBER_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String REQUEST_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

	private Scanner scanner;

	public int inputPurchaseAmount() {
		System.out.println(REQUEST_AMOUNT_MESSAGE);
		return inputNumber();
	}

	public int inputManualCount() {
		System.out.println(REQUEST_MANUAL_NUMBER_COUNT_MESSAGE);
		return inputNumber();
	}

	public List<Integer> inputWinningNumbers() {
		System.out.println(REQUEST_WINNING_NUMBERS_MESSAGE);
		return inputTicketNumbers();
	}

	public List<List<Integer>> inputManualNumbers(int count) {
		System.out.println(REQUEST_MANUAL_NUMBERS_MESSAGE);
		List<List<Integer>> manualNumbers = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			manualNumbers.add(inputTicketNumbers());
		}
		return manualNumbers;
	}

	public int inputBonusNumber(List<Integer> winningNumbers) {
		System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);

		int bonusNumber;
		try {
			bonusNumber = scanner.nextInt();
			ValidationUtil.validateBonusNumber(bonusNumber, winningNumbers);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			bonusNumber = inputBonusNumber(winningNumbers);
		}
		return bonusNumber;
	}

	public void initScanner() {
		this.scanner = new Scanner(System.in);
	}

	public void closeScanner() {
		this.scanner.close();
	}

	private int inputNumber() {
		int result;
		try {
			result = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
			result = inputPurchaseAmount();
		}
		return result;
	}

	private List<Integer> inputTicketNumbers() {
		String[] numbers;
		while (true) {
			try {
				String input = scanner.nextLine();
				numbers = ValidationUtil.validateTicketFormat(input);
				ValidationUtil.checkDuplicate(numbers);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
		return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
	}

}
