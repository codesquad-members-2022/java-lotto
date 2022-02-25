package com.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String REQUEST_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
	private static final String REQUEST_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
	private static final String REQUEST_MANUAL_NUMBER_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String REQUEST_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

	private Scanner scanner;

	public int getPurchaseAmount() {
		System.out.println(REQUEST_AMOUNT_MESSAGE);
		return Integer.parseInt(scanner.nextLine());
	}

	public List<Integer> getWinningNumbers() {
		System.out.println(REQUEST_WINNING_NUMBERS_MESSAGE);
		return inputNumbers();
	}
	public int inputManualCount(){
		System.out.println(REQUEST_MANUAL_NUMBER_COUNT_MESSAGE);
		return Integer.parseInt(scanner.nextLine());
	}
	public List<List<Integer>> inputManualNumbers(int count){
		System.out.println(REQUEST_MANUAL_NUMBERS_MESSAGE);
		List<List<Integer>> manualNumbers = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			manualNumbers.add(inputNumbers());
		}
		return manualNumbers;
	}
	public int inputBonusNumber() {
		System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
		return scanner.nextInt();
	}

	public void initScanner(){
		this.scanner = new Scanner(System.in);
	}

	public void closeScanner(){
		this.scanner.close();
	}
	private List<Integer> inputNumbers() {
		String[] numbers = scanner.nextLine().replaceAll(" ", "").split(",");
		return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
	}
}
