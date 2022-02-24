package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @Test
    void createTest() {
        ArrayList<LottoNumber> list = new ArrayList<>(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        LottoTicket lottoTicket = new LottoTicket(list);
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @Test
    void lottoSizeTest() {
        ArrayList<LottoNumber> list = new ArrayList<>(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5)));
        assertThatThrownBy(() -> new LottoTicket(list)).isInstanceOf(IllegalArgumentException.class);

        ArrayList<LottoNumber> list2 = new ArrayList<>(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7)));
        assertThatThrownBy(() -> new LottoTicket(list2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정답_일치_테스트() {
        String[] winList = new String[]{"1", "2", "3", "7", "8", "9"};
        String[] winList2 = new String[]{"1", "2", "3", "4", "8", "9"};
        String[] winList3 = new String[]{"1", "2", "3", "4", "5", "9"};
        test(new WinningNumbers(winList, "45"), 3);
        test(new WinningNumbers(winList2, "45"), 4);
        test(new WinningNumbers(winList3, "45"), 5);
    }

    public void test(WinningNumbers win, int count) {
        ArrayList<LottoNumber> list = new ArrayList<>(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        LottoTicket lottoTicket = new LottoTicket(list);
        assertThat(lottoTicket.countWinningNumber(win)).isEqualTo(count);
    }
}
