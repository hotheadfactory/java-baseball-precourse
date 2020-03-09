package baseball.domain;

import java.util.List;
import java.util.Objects;

public class BaseballNumbers {
    public static final int SIZE = 3;
    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        Objects.requireNonNull(baseballNumbers);
        if (baseballNumbers.size() != SIZE) {
            throw new IllegalArgumentException("숫자 갯수가 올바르지 않습니다.");
        }
        this.baseballNumbers = baseballNumbers;
    }

    public boolean contains(BaseballNumber baseballNumber) {
        return baseballNumbers.contains(baseballNumber);
    }
}
