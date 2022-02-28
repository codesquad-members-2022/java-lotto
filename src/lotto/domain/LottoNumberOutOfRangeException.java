package lotto.domain;

public class LottoNumberOutOfRangeException extends InvalidLottoNumberException {
    private static final String DEFAULT_MESSAGE = "로또 번호가 유효 범위 밖에 있습니다";

    public LottoNumberOutOfRangeException(int lottoNumberOutOfRange) {
        super(DEFAULT_MESSAGE);
        this.invalidLottoNumber = lottoNumberOutOfRange;
    }

    public LottoNumberOutOfRangeException(String message, int lottoNumberOutOfRange) {
        super(message);
        this.invalidLottoNumber = lottoNumberOutOfRange;
    }

}
