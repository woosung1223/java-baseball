package baseball.domain;

import java.util.Arrays;

public enum GameControl {
    CONTINUE("1"),
    EXIT("2");

    private final String controlFlag;

    GameControl(String controlFlag) {
        this.controlFlag = controlFlag;
    }

    public static GameControl of(String target) {
        return Arrays.stream(values())
                .filter(value -> value.controlFlag.equals(target))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public boolean isContinue() {
        return this.equals(CONTINUE);
    }
}
