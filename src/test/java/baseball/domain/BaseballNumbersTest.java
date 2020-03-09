package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballNumbersTest {
    static Stream<Arguments> validBaseballNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(BaseballNumberFactory.pick(1), BaseballNumberFactory.pick(2), BaseballNumberFactory.pick(3))),
                Arguments.of(Arrays.asList(BaseballNumberFactory.pick(4), BaseballNumberFactory.pick(5), BaseballNumberFactory.pick(6))),
                Arguments.of(Arrays.asList(BaseballNumberFactory.pick(7), BaseballNumberFactory.pick(8), BaseballNumberFactory.pick(9)))
        );
    }

    static Stream<Arguments> invalidBaseballNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(BaseballNumberFactory.pick(1), BaseballNumberFactory.pick(2))),
                Arguments.of(Arrays.asList(BaseballNumberFactory.pick(4), BaseballNumberFactory.pick(5), BaseballNumberFactory.pick(6), BaseballNumberFactory.pick(7)))
        );
    }

    @ParameterizedTest
    @MethodSource("validBaseballNumbers")
    @DisplayName("정상적인 BaseballNumber 리스트가 들어올 경우")
    void validBaseballNumbersTest(List<BaseballNumber> numbers) {
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);
        assertThat(baseballNumbers.contains(numbers.get(0)));
        assertThat(baseballNumbers.contains(numbers.get(1)));
        assertThat(baseballNumbers.contains(numbers.get(2)));
    }

    @ParameterizedTest
    @MethodSource("invalidBaseballNumbers")
    @DisplayName("BaseballNumber의 갯수가 틀릴 경우")
    void wrongBaseballNumbersTest(List<BaseballNumber> numbers) {
        assertThatThrownBy(() -> new BaseballNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 갯수가");
    }
}
