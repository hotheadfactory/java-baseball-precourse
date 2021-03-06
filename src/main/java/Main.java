/**
 * Main.java
 * 숫자야구 게임
 * 우아한테크코스 프리코스 1주차.
 * Original code https://github.com/hotheadfactory/java-baseball-precourse
 * Version: v0.0.1, 2019.11.29 (c) 정회형
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        while (askRetry()) {
            game.init();
        }
    }

    private static boolean askRetry() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
            String decision = sc.nextLine();
            if (decision.charAt(0) == '1') {
                return true;
            }
            if (decision.charAt(0) == '2') {
                return false;
            }
        }
    }
}
