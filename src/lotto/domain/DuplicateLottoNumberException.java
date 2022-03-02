package lotto.domain;

public class DuplicateLottoNumberException extends InvalidLottoNumberException {
    private static final String DEFAULT_MESSAGE = "로또 번호는 중복이 없어야 합니다";

    public DuplicateLottoNumberException(int[] duplicateLottoNumbers) {
        super(DEFAULT_MESSAGE);
        this.invalidLottoNumbers = duplicateLottoNumbers;
    }

    public DuplicateLottoNumberException(String message, int[] duplicateLottoNumbers) {
        super(message);
        this.invalidLottoNumbers = duplicateLottoNumbers;
    }


}
