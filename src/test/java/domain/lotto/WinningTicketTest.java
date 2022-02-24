package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class WinningTicketTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 겹칠 때 WinningTicket 생성 시 예외 발생")
    void createWinningTicket() {
        Set<LottoNumber> winningNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                                    LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                                                .collect(Collectors.toSet());

        LottoNumber bonusNumber = LottoNumber.of(6);
        assertThatThrownBy(() -> new WinningTicket(winningNumbers, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

}
