package baseball.domain;

import java.util.Arrays;

public enum GameControl {
    CONTINUE(1),
    EXIT(2);

    private final int controlFlag;

    GameControl(int controlFlag) {
        this.controlFlag = controlFlag;
    }

    public static GameControl of(int target) {
        return Arrays.stream(values())
                .filter(value -> value.controlFlag == target)
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public boolean isContinue() {
        return this.equals(CONTINUE);
    }
}
