package baseball.verifier;

import java.util.stream.Stream;

public class UserNumberVerifier {
    private final int NUMBER_SIZE = 3;

    private final String IS_NOT_NUMERIC = "[ERROR] 입력된 값은 숫자가 아닙니다.";
    private final String IS_OUT_OF_RANGE = "[ERROR] " + NUMBER_SIZE + "자리 수를 입력해주세요.";
    private final String EACH_IS_NOT_DISTINCT = "[ERROR] 입력된 값에서 중복된 자리수가 존재합니다.";
    private final String EACH_OUT_OF_RANGE = "[ERROR] 입력된 값은 범위에서 벗어납니다.";

    public void check(String target) {
        checkNumeric(target);
        checkNumberRange(target);
        checkEachDistinct(target);
        checkEachInRange(target);
    }

    private void checkNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMERIC);
        }
    }

    private void checkNumberRange(String target) {
        if (target.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(IS_OUT_OF_RANGE);
        }
    }

    private void checkEachDistinct(String target) {
        int distinctValueCount = (int) Stream.iterate(0, i -> i + 1)
                .limit(NUMBER_SIZE)
                .filter(i -> target.indexOf(target.charAt(i), i + 1) == -1)
                .count();

        if (distinctValueCount != NUMBER_SIZE) {
            throw new IllegalArgumentException(EACH_IS_NOT_DISTINCT);
        }
    }

    private void checkEachInRange(String target) {
        int validNumberCount = (int) Stream.iterate(0, i -> i + 1)
                .limit(target.length())
                .filter(i -> target.charAt(i) >= '1' && target.charAt(i) <= '9')
                .count();

        if (validNumberCount != target.length()) {
            throw new IllegalArgumentException(EACH_OUT_OF_RANGE);
        }
    }
}
