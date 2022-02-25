package application.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    SoftAssertions softAssertions;
    Validation validation;

    @BeforeEach
    void testSet() {
        softAssertions = new SoftAssertions();
        validation = new Validation();
    }

    @Test
    @DisplayName("1000원 이상인 값에 true, 1000원 미만인 값에 false를 반환해야 한다.")
    void validatePurchaseAmountTest() {
        //given
        int purchaseAmountA = 1000;
        int purchaseAmountB = 999;
        //when
        boolean resultA = validation.validatePurchaseAmount(purchaseAmountA);
        boolean resultB = validation.validatePurchaseAmount(purchaseAmountB);
        //then
        assertSoftly(
                softAssertions -> {
                    assertThat(resultA).as("1000원 이상이면 true를 반환해야 한다.").isTrue();
                    assertThat(resultB).as("1000원 미만이면 false를 반환해야 한다.").isFalse();
                }
        );
    }

    @Test
    @DisplayName("정확한 형식의 로또 스트링이 주어졌을 때 true를, 부정확할 때 false를 반환해야 한다.")
    void validateGetManualLottoTest() {
        //given
        String manualLottoStringA = "1, 2, 3, 4, 5, 6";
        String manualLottoStringB = "1; 2, 3, 4, 5, 6;";
        //when
        boolean resultA = validation.validateGetManualLotto(manualLottoStringA);
        boolean resultB = validation.validateGetManualLotto(manualLottoStringB);

        //then
        assertSoftly(
                softAssertions -> {
                    assertThat(resultA).as("정확한 형식일 때 true를 반환해야 한다.").isTrue();
                    assertThat(resultB).as("부정한 형식일 때 false를 반환해야 한다.").isFalse();
                }
        );
    }
}
