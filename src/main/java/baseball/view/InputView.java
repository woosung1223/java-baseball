package baseball.view;

import baseball.verifier.UserControlVerifier;
import baseball.verifier.UserNumberVerifier;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String READ_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private final String READ_CONTROL_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public int readNumber() {
        System.out.print(READ_NUMBER_MESSAGE);
        String line = Console.readLine();
        UserNumberVerifier userNumberVerifier = new UserNumberVerifier();
        userNumberVerifier.check(line);
        return Integer.parseInt(line);
    }

    public int readControl() {
        System.out.println(READ_CONTROL_MESSAGE);
        String line = Console.readLine();
        UserControlVerifier userControlVerifier = new UserControlVerifier();
        userControlVerifier.check(line);
        // TODO: int 자료형이 아닌 객체 타입으로 반환하기. Control 값은 언제나 바뀔 수 있다.
        return Integer.parseInt(line);
    }
}
