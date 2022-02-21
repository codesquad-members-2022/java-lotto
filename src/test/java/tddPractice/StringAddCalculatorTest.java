package tddPractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    StringAddCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)")
    void nullAndEmptyTest() {
        assertThat(stringCalculator.calculate(null)).isEqualTo(0);
        assertThat(stringCalculator.calculate("")).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4","12"})
    @DisplayName("2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    void numberCountIsOne(String string) {
        assertThat(stringCalculator.calculate(string)).isEqualTo(Integer.parseInt(string));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3","3,5:8","4,5:9"}, delimiter = ':')
    @DisplayName("3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    void addWithComma(String actual, int expected) {
        assertThat(stringCalculator.calculate(actual)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3;6","3:5,7;15"}, delimiter = ';')
    @DisplayName("4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    void commaOrColonIsPlus(String actual, int expected) {
        assertThat(stringCalculator.calculate(actual)).isEqualTo(expected);
    }
}
