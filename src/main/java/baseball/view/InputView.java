package baseball.view;

import baseball.domain.BaseballNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputBaseballNumbers() {
        try {
            System.out.println(BaseballNumbers.SIZE + "자리 숫자를 입력해 주세요.");
            return Arrays.stream(scanner.nextLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해 주십시오.");
            return inputBaseballNumbers();
        }
    }
}
