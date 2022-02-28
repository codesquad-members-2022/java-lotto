package lotto.domain;

import java.util.Arrays;

public class InvalidLottoNumberException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "유효하지 않은 로또 번호입니다";
    protected int[] invalidLottoNumbers;
    protected Integer invalidLottoNumber;

    public InvalidLottoNumberException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidLottoNumberException(String message) {
        super(message);
    }

    public InvalidLottoNumberException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public InvalidLottoNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLottoNumberException(Throwable cause, int[] invalidLottoNumbers) {
        super(DEFAULT_MESSAGE, cause);
        this.invalidLottoNumbers = invalidLottoNumbers;
    }


    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (invalidLottoNumbers != null) {
            message = message + " : " + Arrays.toString(invalidLottoNumbers);
        }
        if (invalidLottoNumber != null) {
            message = message + " : " + invalidLottoNumber;
        }
        if (getCause() != null) {
            message = message + System.lineSeparator() + getCause().getMessage();
        }

        return message;
    }
}
