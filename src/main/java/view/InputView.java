package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final String PROMPT = "> ";
    private static final String PROMPT_GET_INPUT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_NOT_NUMBER = "숫자를 입력해 주세요.";

    public int getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(PROMPT_GET_INPUT);
        System.out.print(PROMPT);
        String temp;
        while (!isValid(temp = br.readLine())) {
            System.out.println(PROMPT_NOT_NUMBER);
            System.out.print(PROMPT);
        }
        return Integer.parseInt(temp) / 1000;
    }

    private boolean isValid(String input) {
        if (input.matches("\\d+")) {
            return true;
        }
        return false;
    }
}
