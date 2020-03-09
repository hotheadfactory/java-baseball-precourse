package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballNumberTest {
    @ParameterizedTest
    @ValueSource(ints= {0, 9})
    @DisplayName("숫자가 잘 들어가는지 확인")
    void makeNumberTest(int value) {
        assertThat(new BaseballNumber(value)
                .equals(new BaseballNumber(value)))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints= {-1, 10})
    @DisplayName("범위를 벗어난 숫자에 에러를 발생시키는지 확인")
    void wrongNumberTest(int value) {
        assertThatThrownBy(() -> new BaseballNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위를 벗어난 숫자");
    }
}
