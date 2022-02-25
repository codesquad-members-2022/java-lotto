package com.lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ValidationUtil {
	private static final String NUMBER_PATTERN = "([1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5])((, )([1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5])){5}";

	public static void validateManualCountRange(int count, int purchaseAmount) {
		if (count > purchaseAmount / 1000 || count < 0) {
			throw new IllegalArgumentException("숫자를 확인해주세요.");
		}
	}

	public static String[] validateTicketFormat(String ticketNumbers) {

		if (!Pattern.matches(NUMBER_PATTERN, ticketNumbers)) {
			throw new IllegalArgumentException("형식이 올바르지 않습니다");
		}
		return ticketNumbers.replaceAll(" ", "").split(",");
	}

	public static void checkDuplicate(String[] ticketNumbers) {
		Set<String> result = new HashSet<>();
		for (String ticketNumber : ticketNumbers) {
			result.add(ticketNumber);
		}
		if (result.size() != 6) {
			throw new IllegalArgumentException("숫자가 중복되지 없도록 입력해주세요.");
		}
	}

	public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
		if (bonusNumber > 46 || bonusNumber < 1) {
			throw new IllegalArgumentException("1 ~ 45 사이의 숫자를 입력해주세요.");
		}
		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("당첨번호와 중복되지 않는 번호로 입력해주세요.");
		}
	}
}
