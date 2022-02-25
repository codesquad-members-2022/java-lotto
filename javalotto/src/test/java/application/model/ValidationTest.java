package application.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import application.domain.Lotto;

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
    void validateLottoStringTest() {
        //given
        String manualLottoStringA = "11, 22, 33, 44, 37, 41";
        String manualLottoStringB = "1; 2, 3, 4, 5, 6;";
        //when
        boolean resultA = validation.validateLottoString(manualLottoStringA);
        boolean resultB = validation.validateLottoString(manualLottoStringB);

        //then
        assertSoftly(
                softAssertions -> {
                    assertThat(resultA).as("정확한 형식일 때 true를 반환해야 한다.").isTrue();
                    assertThat(resultB).as("부정한 형식일 때 false를 반환해야 한다.").isFalse();
                }
        );
    }

    @Test
    @DisplayName("지불한 금액보다 구매할 로또의 개수가 많거나 개수를 음수로 입력하면 false를 반환해야 한다.")
    void validateNumberOfManualLottoTest() {
        //given
        int numberOfManualLottoA = -1;
        int numberOfManualLottoB = 2;
        int money = 1000;
        //when
        boolean resultA = validation.validateNumberOfManualLotto(numberOfManualLottoA, money);
        boolean resultB = validation.validateNumberOfManualLotto(numberOfManualLottoB, money);
        //then
        assertSoftly(
                softAssertions -> {
                    assertThat(resultA).as("입력된 개수가 음수이면 false를 반환해야 한다.").isFalse();
                    assertThat(resultB).as("돈이 부족할 때 false를 반환해야 한다.").isFalse();
                }
        );
    }

    @Test
    @DisplayName("보너스볼의 번호가 1~45의 정수값을 가지면 true, 아니면 false를 반환해야 한다")
    void validateBonusBallNumberRange() {
        //given
        int bonusBallNumberA = 1;
        int bonusBallNumberB = 7;
        int bonusBallNumberC = 46;
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningNumberLotto = new Lotto(winningNumber);

        //when
        boolean resultA = validation.validateBonusBallNumberRange(bonusBallNumberA, winningNumberLotto);
        boolean resultB = validation.validateBonusBallNumberRange(bonusBallNumberB, winningNumberLotto);
        boolean resultC = validation.validateBonusBallNumberRange(bonusBallNumberC, winningNumberLotto);
        //then
        assertSoftly(
                softAssertions -> {
                    assertThat(resultA).as("지난주 당첨 번호와 보너스 번호가 중복 되면 false를 반환해야 한다.").isFalse();
                    assertThat(resultB).as("보너스볼의 번호가 1~45의 정수값을 가지면 true를 반환해야 한다.").isTrue();
                    assertThat(resultC).as("범위를 벗어났을 때 false를 반환해야 한다.").isFalse();
                }
        );
    }
}
