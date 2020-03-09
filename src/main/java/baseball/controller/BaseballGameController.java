package baseball.controller;

import baseball.domain.BaseballNumberFactory;
import baseball.domain.BaseballNumbers;
import baseball.view.InputView;

import java.util.Map;
import java.util.stream.Collectors;

public class BaseballGameController {
    public static void init() {
        BaseballNumbers winningNumbers = BaseballNumberFactory.pickRandomNumbers();
        guessNumber(winningNumbers);
    }

    private static void guessNumber(BaseballNumbers winningNumbers) {
        while (true) {
            Map<String, Integer> result = winningNumbers.checkStrikeOrBall(parseUserNumbers());
            System.out.printf("%d스트라이크 %d볼\n\n", result.get("Strike"), result.get("Ball"));
            if (result.get("Strike") == 3) {
                System.out.println("정답!");
                break;
            }
        }
    }

    private static BaseballNumbers parseUserNumbers() {
        try {
            return new BaseballNumbers(InputView.inputBaseballNumbers().stream()
                    .map(BaseballNumberFactory::pick)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return parseUserNumbers();
        }
    }
}
