package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("로또 번호가 5개 일치하고 보너스볼이 일치하면, 2등(rank2)을 반환한다.")
    void getMatchedRank_Rank2() {
        assertThat(Rank.getMatchedRank(5,true)).isEqualTo(Rank.rank2);
    }

    @Test
    @DisplayName("로또 번호가 5개 일치하고 보너스볼이 일치하지 않으면, 3등(rank3)을 반환한다.")
    void getMatchedRank_Rank3() {
        assertThat(Rank.getMatchedRank(5,false)).isEqualTo(Rank.rank3);
    }
}
