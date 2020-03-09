package baseball.view;

import java.util.Map;

public class OutputView {
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크 ";
    public static final String BALL = "볼";

    public static void printResult(Map<String, Integer> result) {
        int strike = result.get("Strike");
        int ball = result.get("Ball");

        System.out.println(makeResultMessage(strike, ball));
    }

    private static String makeResultMessage(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        if (strike > 0) {
            sb.append(strike).append(STRIKE);
        }
        if (ball > 0) {
            sb.append(ball).append(BALL);
        }
        return sb.toString();
    }

    public static void printCorrect() {
        System.out.println("정답!");
    }
}
