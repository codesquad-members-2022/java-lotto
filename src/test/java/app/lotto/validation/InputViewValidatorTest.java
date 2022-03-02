package app.lotto.validation;

import app.lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewValidatorTest {

    @Nested
    @DisplayName("validateAmountUnit 메서드는")
    class ValidateAmountUnitTest {

        @Test
        @DisplayName("금액이 1000원이고 단위도 1000원이면 성공한다.")
        void sameAmountUnitTest() {
            int amount = 1000;
            int unit = 1000;

            try {
                InputViewValidator.validateAmountUnit(amount, unit);
            } catch (IllegalArgumentException e) {
                fail();
            }
        }

        @Test
        @DisplayName("금액이 1500원이고 단위가 1000원이면 IllegalArgumentException 예외가 발생한다.")
        void differentAmountUnitTest() {
            int amount = 1500;
            int unit = 1000;

            assertThrows(IllegalArgumentException.class, () -> {
                InputViewValidator.validateAmountUnit(amount, unit);
            });
        }
    }

    @Nested
    @DisplayName("validateNumbersCount 메소드는")
    class ValidateNumbersCountTest {

        @Test
        @DisplayName("numbers 배열에 숫자만 있고, 개수가 정확하면 성공한다")
        void array_Has_Number_And_Same_Count() {
            // given
            String[] numbers = {"1", "2", "3", "4", "5", "6"};
            int count = numbers.length;

            // then
            try {
                InputViewValidator.validateNumbersCount(numbers, count);
            } catch (IllegalArgumentException e) {
                fail();
            }
        }

        @Test
        @DisplayName("numbers 배열에 숫자가 아닌 다른 요소가 있으면, IllegalArgumentException 예외가 발생한다.")
        void array_Has_Character() {
            // given
            String[] numbers = {"A", "2", "3", "4", "5", "6"};
            int count = numbers.length;

            // then
            assertThrows(IllegalArgumentException.class, () -> {
                InputViewValidator.validateNumbersCount(numbers, count);
            });
        }

        @Test
        @DisplayName("numbers 배열에 숫자만 있지만, 개수가 다르면 IllegalArgumentException 예외가 발생한다.")
        void array_Has_Number_But_Different_Count() {
            // given
            String[] numbers = {"1", "2", "3", "4", "5", "6"};
            int count = 5;

            // then
            assertThrows(IllegalArgumentException.class, () -> {
                InputViewValidator.validateNumbersCount(numbers, count);
            });
        }
    }

    @Nested
    @DisplayName("validateNumbersRange 메소드는")
    class ValidateNumbersRangeTest {
        @Test
        @DisplayName("로또 번호의 범위가 1 이상 45 이하면 성공한다.")
        void lotto_Numbers_are_between_1_and_45 () {
            // given
            LottoTicket ticket = LottoTicket.createWithStringNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
            int min = 1;
            int max = 45;

            // then
            try {
                InputViewValidator.validateNumbersRange(ticket, min, max);
            } catch (IllegalArgumentException e) {
                fail();
            }
        }

        @Test
        @DisplayName("로또 번호의 범위가 1 이상 45 이하를 벗어나면 IllegalArgumentException 예외가 발생한다.")
        void lotto_Numbers_are_not_between_1_and_45 () {
            // given
            LottoTicket ticket = LottoTicket.createWithStringNumbers(new String[]{"100", "2", "3", "4", "5", "6"});
            int min = 1;
            int max = 45;

            // then
            assertThrows(IllegalArgumentException.class, () -> {
                InputViewValidator.validateNumbersRange(ticket, min, max);
            });
        }

        @Test
        @DisplayName("로또 번호 범위의 최소값이 최대값보다 크면 IllegalArgumentException 예외가 발생한다.")
        void minimum_value_should_not_be_greater_than_maximum_value () {
            // given
            LottoTicket ticket = LottoTicket.createWithStringNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
            int min = 40;
            int max = 1;

            // then
            assertThrows(IllegalArgumentException.class, () -> {
                InputViewValidator.validateNumbersRange(ticket, min, max);
            });
        }
    }

    @Nested
    @DisplayName("validateRange 메소드는")
    class ValidateRangeTest {

        @Test
        @DisplayName("num은 최소값과 최대값 사이 범위에 있으면 성공한다.")
        void range_between_min_and_max() {
            int min = 1;
            int max = 45;
            int num = 5;

            try {
                InputViewValidator.validateRange(min, max, num);
            } catch (IllegalArgumentException e) {
                fail();
            }
        }

        @Test
        @DisplayName("num이 최소값과 최대값 범위를 벗어나면 IllegalArgumentException 예외가 발생한다.")
        void invalid_range () {
            // given
            int min = 1;
            int max = 45;
            int num = 50;

            // then
            assertThrows(IllegalArgumentException.class, () -> {
                InputViewValidator.validateRange(min, max, num);
            });
        }
    }

    @Nested
    @DisplayName("validateDuplicatedNumber 메소드는")
    class ValidateDuplicatedNumberTest {
        @Test
        @DisplayName("중복된 숫자가 있으면 IllegalArgumentException 예외가 발생한다.")
        void duplicatedNumber_throwIllegalArgumentException() {
            // given
            String[] numbers = {"1", "1", "1", "4", "5", "6"};

            // then
            assertThrows(IllegalArgumentException.class, () -> {
                InputViewValidator.validateDuplicatedNumber(numbers);
            });
        }

        @Test
        @DisplayName("중복된 숫자가 없으면 성공합니다.")
        void nonDuplicatedNumber_success() {
            // given
            String[] numbers = {"1", "2", "3", "4", "5", "6"};

            // then
            try {
                InputViewValidator.validateDuplicatedNumber(numbers);
            } catch (IllegalArgumentException e) {
                fail();
            }
        }
    }

}