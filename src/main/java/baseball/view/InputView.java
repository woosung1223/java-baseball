package baseball.view;

import baseball.verifier.UserControlVerifier;
import baseball.verifier.UserNumberVerifier;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static int readNumber() {
        String line = Console.readLine();
        UserNumberVerifier userNumberVerifier = new UserNumberVerifier();
        userNumberVerifier.check(line);
        return Integer.parseInt(line);
    }

    public static int readControl() {
        String line = Console.readLine();
        UserControlVerifier userControlVerifier = new UserControlVerifier();
        userControlVerifier.check(line);
        // TODO: int 자료형이 아닌 객체 타입으로 반환하기. Control 값은 언제나 바뀔 수 있다.
        return Integer.parseInt(line);
    }
}
