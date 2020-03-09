package baseball.view;

import java.util.Map;

public class OutputView {
    public static void printResult(Map<String, Integer> result) {
        System.out.printf("%d스트라이크 %d볼\n\n", result.get("Strike"), result.get("Ball"));
    }

    public static void printCorrect() {
        System.out.println("정답!");
    }
}
