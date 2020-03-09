package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberFactory {
    private static final List<BaseballNumber> baseballNumbers = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            baseballNumbers.add(new BaseballNumber(i));
        }
    }

    public static BaseballNumber pick(int value) {
        return baseballNumbers.stream()
                .filter(n -> n.is(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 숫자입니다."));
    }
}
