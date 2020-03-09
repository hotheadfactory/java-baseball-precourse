package baseball.domain;

public class BaseballNumber {
    private final int baseballNumber;

    public BaseballNumber(int baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public boolean equals(BaseballNumber number) {
        return this.baseballNumber == number.baseballNumber;
    }
}
