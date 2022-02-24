import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MainTest {

    @Test
    @DisplayName("assertj 임포트 테스트")
    public void importAssertJTest() {
        assertThat("hello-world").isEqualTo("hello-world");
    }

}
