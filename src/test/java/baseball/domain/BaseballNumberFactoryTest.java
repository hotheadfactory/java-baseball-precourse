package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballNumberFactoryTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 9})
    @DisplayName("정상 숫자를 뽑는 것을 테스트")
    void pickBaseballNumberTest(int value) {
        assertThat(BaseballNumberFactory.pick(value)).isEqualTo(BaseballNumberFactory.pick(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("잘못된 숫자를 뽑는 것을 테스트")
    void pickWrongBaseballNumberTest(int value) {
        assertThatThrownBy(() -> BaseballNumberFactory.pick(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 숫자");
    }
}
