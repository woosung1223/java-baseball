package baseball.verifier;

public class UserControlVerifier {
    private final String IS_NOT_NUMERIC = "[ERROR] 입력된 값은 숫자가 아닙니다.";
    private final String IS_NOT_UNDERSTANDABLE = "[ERROR] 이해할 수 없는 값입니다.";

    public void check(String target) {
        checkNumeric(target);
        checkUnderstandable(target);
    }

    private void checkNumeric(String target) {
        // TODO: 숫자가 아닌 경우를 위해 확장성 있게 설계, enum 정의 이후
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMERIC);
        }
    }

    private void checkUnderstandable(String target) {
        // TODO: 확장성 있게 설계. 원시형을 그대로 다루지 말고. 이것도 enum 정의 이후.
        if (!(target.equals("1") || target.equals("2"))) {
            throw new IllegalArgumentException(IS_NOT_UNDERSTANDABLE);
        }
    }
}
