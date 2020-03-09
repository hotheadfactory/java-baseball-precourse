package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumberFactory {
    private static final List<BaseballNumber> allBaseballNumbers;

    static {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            baseballNumbers.add(new BaseballNumber(i));
        }
        allBaseballNumbers = Collections.unmodifiableList(baseballNumbers);
    }

    public static BaseballNumber pick(int value) {
        return allBaseballNumbers.stream()
                .filter(n -> n.is(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 숫자입니다."));
    }

    public static BaseballNumbers pickRandomNumbers() {
        List<BaseballNumber> baseballNumbersCache = new ArrayList<>(allBaseballNumbers);
        Collections.shuffle(baseballNumbersCache);
        return new BaseballNumbers(baseballNumbersCache.stream()
                .limit(BaseballNumbers.SIZE)
                .collect(Collectors.toList()));
    }
}
