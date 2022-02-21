package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PROMPT = "> ";
    private static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_NOT_NUMBER = "숫자를 입력해 주세요.";
    private static final String PROMPT_ANSWER = "당첨 번호를 입력해 주세요.";
    private static final Scanner sc = new Scanner(System.in);

    public int getMoneyInput()  {
        System.out.println(PROMPT_MONEY);
        System.out.print(PROMPT);
        String temp;
        while (!isValid(temp = sc.nextLine())) {
            System.out.println(PROMPT_NOT_NUMBER);
            System.out.print(PROMPT);
        }
        return Integer.parseInt(temp);
    }

    public List<Integer> getAnswerInput() {
        System.out.println(PROMPT_ANSWER);
        System.out.print(PROMPT);
        String[] answer = sc.nextLine().split(",\\s+");
        // TODO: 입력 예외 처리(숫자인지, 개수 6개인지, 로또번호 범위(1~45) 내인지)
        return Arrays.stream(answer)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private boolean isValid(String input) {
        if (input.matches("\\d+")) {
            return true;
        }
        return false;
    }
}
