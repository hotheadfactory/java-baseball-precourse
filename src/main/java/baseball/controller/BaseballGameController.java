package baseball.controller;

import baseball.domain.BaseballNumberFactory;
import baseball.domain.BaseballNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

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
            OutputView.printResult(result);
            if (result.get("Strike") == 3) {
                OutputView.printCorrect();
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
