package view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    InputValidator iv = InputValidator.getInstance();

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a", "ab"})
    @DisplayName("빈문자 또는 문자가 입력되면 \"숫자를 입력해주세요.\"라는 메세지를 담은 IllegalArgumentException을 던진다.")
    void validateInteger_InvalidString(String input) {
        assertThatThrownBy(() -> iv.validateInteger(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {Integer.MAX_VALUE + "111"})
    @DisplayName("입력값이 정수 범위를 벗어나면 \"int 범위 내로 입력해주세요.\"라는 메세지를 담은 IllegalArgumentException을 던진다.")
    void validateInteger_OutOfIntegerRange(String input) {
        assertThatThrownBy(() -> iv.validateInteger(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("int 범위 내로 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "7", "-40", "0"})
    @DisplayName("정수 형태의 String을 입력하면 int 타입으로 변환하여 리턴한다.")
    void validateInteger(String input) {
        assertThat(iv.validateInteger(input)).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2", "0"})
    @DisplayName("입력값이 양수범위를 벗어나면 \"양수를 입력해 주세요.\"라는 메세지를 담은 IllegalArgumentException을 던진다.")
    void validatePositiveInteger_NegativeInput(String input) {
        assertThatThrownBy(() -> iv.validatePositiveInteger(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("양수를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "7"})
    @DisplayName("양수의 String을 입력하면 int 타입으로 변환하여 리턴한다.")
    void validatePositiveInteger(String input) {
        assertThat(iv.validateInteger(input)).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
    @DisplayName("입력 값이 6개가 아니면 \"중복 없는 6개의 번호를 입력해주세요.\"라는 메세지를 담은 IllegalArgumentException을 던진다.")
    void validateWinningNumber_InvalidSize(String input) {
        assertThatThrownBy(() -> iv.validateLottoNumbers(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복 없는 6개의 번호를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 2, 3, 4, 5"})
    @DisplayName("입력 값 중에 중복 값이 있으면 \"중복 없는 6개의 번호를 입력해주세요.\"라는 메세지를 담은 IllegalArgumentException을"
        + " 던진다.")
    void validateWinningNumber_DuplicateInput(String input) {
        assertThatThrownBy(() -> iv.validateLottoNumbers(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복 없는 6개의 번호를 입력해주세요.");
    }

    @Test
    @DisplayName("중복되지 않는 로또 범위 내의 6개의 정수로 이루어진 스트링을 입력하면, List<Integer>를 반환한다.")
    void validateWinningNumber() {
        assertThat(iv.validateLottoNumbers("1,5,10,40,42,43"))
            .containsOnly(1, 5, 10, 40, 42, 43);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    @DisplayName("입력 값이 로또 범위를 벗어나면 \"1~45 내의 숫자를 입력해주세요.\"라는 메세지를 담은 IllegalArgumentException을 "
        + "던진다.")
    void validateLottoNumber_OutOfLottoRange(int input) {
        assertThatThrownBy(() -> iv.validateLottoNumber(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("1~45 내의 숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("로또 범위 내의 정수가 입력되면 해당 int 값을 반환한다.")
    void validateLottoNumber(int input) {
        assertThat(iv.validateLottoNumber(input)).isEqualTo(input);
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호 리스트와 중복되면 당첨번호 리스트 내용과 함께\"중복되지 않는 값을 입력해주세요.\"라는 예외를 던진다.")
    void validateBonusNumber_DuplicateInput() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> iv.validateBonusNumber(winningNumbers, "6"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복되지 않는 값을 입력해주세요.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호 리스트와 중복되지 않으면 해당 보너스 번호를 반환한다.")
    void validateBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(iv.validateBonusNumber(winningNumbers, "7")).isEqualTo(7);
    }

    @Test
    @DisplayName("구입금액으로 구매 가능한 로또 수를 초과하는 수를 입력하면\"구매한 로또 개수 내에서 입력해 주세요.\"라는 예외를 "
        + "던진다.")
    void validateManualLottoCount_OutOfRange() {
        assertThatThrownBy(() -> iv.validateManualLottoCount(14000, "15"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구매한 로또 개수 내에서 입력해 주세요.");
    }

    @Test
    @DisplayName("구입금액으로 구매 가능한 로또 수 한도 내의 수를 입력하면 해당 입력값을 int로 변환하여 반환한다.")
    void validateManualLottoCount() {
        assertThat(iv.validateManualLottoCount(14000, "12")).isEqualTo(12);
    }
}
