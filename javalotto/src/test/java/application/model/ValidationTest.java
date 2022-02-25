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
}
