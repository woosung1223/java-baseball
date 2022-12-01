package baseball.verifier;

import baseball.domain.GameControl;

public class UserControlVerifier {
    private final String IS_NOT_UNDERSTANDABLE = "[ERROR] 이해할 수 없는 값입니다.";

    public void check(String target) {
        checkUnderstandable(target);
    }

    private void checkUnderstandable(String target) {
        try {
            GameControl.of(target);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(IS_NOT_UNDERSTANDABLE);
        }
    }
}
