package lotto.domain;

public class WrongSizedLottoNumberException extends InvalidLottoNumberException {
    private static final String DEFAULT_MESSAGE = "로또 번호의 갯수가 올바르지 않습니다";

    public WrongSizedLottoNumberException(int[] wrongSizedLottoNumbers) {
        super(DEFAULT_MESSAGE);
        this.invalidLottoNumbers = wrongSizedLottoNumbers;
    }

    public WrongSizedLottoNumberException(String message, int[] wrongSizedLottoNumbers) {
        super(message);
        this.invalidLottoNumbers = wrongSizedLottoNumbers;
    }
}
