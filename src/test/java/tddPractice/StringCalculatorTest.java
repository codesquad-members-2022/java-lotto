package tddPractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {


    @ParameterizedTest
    @CsvSource(value = {"2:3:5", "10:4:14", "999:1:1000"},delimiter = ':')
    @DisplayName("두 수 더하기")
    void addTest(double a, double b, int expected) {
        assertThat(StringCalculator.add(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:3:2", "10:4:6", "999:1:998"},delimiter = ':')
    @DisplayName("두 수 빼기")
    void subTest(double a, double b, int expected) {
        assertThat(StringCalculator.subtract(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:3:6", "10:4:40", "999:1:999"},delimiter = ':')
    @DisplayName("두 수 곱하기")
    void multiplyTest(double a, double b, int expected) {
        assertThat(StringCalculator.multiply(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:2:3", "10:2:5", "999:1:999"},delimiter = ':')
    @DisplayName("두 수 나누기")
    void divideTest(double a, double b, int expected) {
        assertThat(StringCalculator.divide(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("calculate 테스트")
    @CsvSource(value = {"2 + 3 * 4 / 2 : 10", "10 + 5 / 2 : 7.5"}, delimiter = ':')
    void calculateTest(String input, double expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("0을 나누거나 0으로 나누면 익셉션이 발생한다.")
    @CsvSource(value = {"6:0", "0:5", "999:0"},delimiter = ':')
    void divideZeroThrowsException(double a, double b) {
        assertThatThrownBy(() -> StringCalculator.divide(a, b))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0은 나눌 수 없습니다.");
    }

}
