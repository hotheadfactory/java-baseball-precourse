package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberTest {
    @ParameterizedTest
    @ValueSource(ints= {0, 9})
    @DisplayName("숫자가 잘 들어가는지 확인")
    void makeNumberTest(int value) {
        assertThat(new BaseballNumber(value)
                .equals(new BaseballNumber(value)))
                .isTrue();
    }
}
