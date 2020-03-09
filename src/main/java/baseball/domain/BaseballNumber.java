package baseball.domain;

public class BaseballNumber {
    private final int baseballNumber;

    public BaseballNumber(int baseballNumber) {
        if(baseballNumber < 0 || baseballNumber > 9) {
            throw new IllegalArgumentException("범위를 벗어난 숫자를 입력했습니다!");
        }
        this.baseballNumber = baseballNumber;
    }

    public boolean is(int value) {
        return value == baseballNumber;
    }
}
