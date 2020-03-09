package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Map<String, Integer> checkStrikeOrBall(BaseballNumbers numbers) {
        Map<String, Integer> result = new HashMap<>();
        result.put("Strike", 0);
        result.put("Ball", 0);
        for (int i = 0; i < SIZE; i++) {
            if (this.baseballNumbers.get(i).equals(numbers.baseballNumbers.get(i))) {
                result.put("Strike", result.get("Strike") + 1);
                continue;
            }
            if (this.baseballNumbers.contains(numbers.baseballNumbers.get(i))) {
                result.put("Ball", result.get("Ball") + 1);
            }
        }
        return result;
    }

    public boolean contains(BaseballNumber baseballNumber) {
        return this.baseballNumbers.contains(baseballNumber);
    }
}
